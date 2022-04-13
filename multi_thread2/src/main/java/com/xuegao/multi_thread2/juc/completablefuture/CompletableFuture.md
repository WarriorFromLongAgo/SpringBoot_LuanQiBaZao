两任务全部执行完成
thenCombine()使用
CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
System.out.println("1:" + Thread.currentThread().getName());
return 123;
}, executor);
CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> {
System.out.println("2:" + Thread.currentThread().getName());
return 123;
}, executor);
CompletableFuture<Integer> future3 = future1.thenCombineAsync(future2, (f1, f2) -> {
System.out.println("3:" + Thread.currentThread().getName());
System.out.println("第1个任务结果:" + f1);
System.out.println("第2个任务结果:" + f2);
return 3;
},executor);
System.out.println("最后执行结果:" + future3.get());
复制代码
**
执行结果：
1:pool-1-thread-1
2:pool-1-thread-2
3:pool-1-thread-3
第1个任务结果:123
第2个任务结果:123
最后执行结果:3

作者：silly8543
链接：https://juejin.cn/post/6993117955043098631
来源：稀土掘金
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。