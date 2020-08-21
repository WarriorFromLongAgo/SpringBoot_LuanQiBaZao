package com.xuegao.multi_thread2.limit.aspect;

import com.google.common.util.concurrent.RateLimiter;

/**
 * <br/> @PackageName：com.xuegao.multi_thread2.limit.aspect
 * <br/> @ClassName：TokenBucketLimiterGuavaTest
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/8/16 16:38
 */
public class TokenBucketLimiterGuavaTest {
    public static void main(String[] args) {
        guavaLimitTest2();
    }

    // Guava令牌桶算法的特点
    // RateLimiter使用令牌桶算法，会进行令牌的累积，如果获取令牌的频率比较低，
    //     则不会导致等待，直接获取令牌。
    // RateLimiter由于会累积令牌，所以可以应对突发流量。
    //     也就是说如果同时请求5个令牌，由于此时令牌桶中有累积的令牌，能够快速响应请求。
    // RateLimiter在没有足够的令牌发放时，采用的是滞后的方式进行处理，
    //     也就是前一个请求获取令牌所需要等待的时间由下一次请求来承受和弥补，也就是代替前一个请求进行等待。
    //     （这里，小伙伴们要好好理解下）

    /**
     * <br/> @Title: 正常流量
     * <br/> @MethodName:  guavaLimitTest1
     * <br/>
     * <br/> @Return void
     * <br/> @Description:
     * <br/> @author: 80004960
     * <br/> @date:  2020/8/16 16:40
     */
    private static void guavaLimitTest1() {
        //每秒钟生成5个令牌
        RateLimiter limiter = RateLimiter.create(5);

        // 0.0
        // 0.18552
        // 0.198428
        // 0.200706
        // 0.199235
        // 0.200072
        // 0.199622
        // 0.199479
        // 0.199417
        // 0.199524

        //返回值表示从令牌桶中获取一个令牌所花费的时间，单位是秒
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));

        // 从输出结果可以看出：第一次从桶中获取令牌时，返回的时间为0.0，也就是没耗费时间。
        // 之后每次从桶中获取令牌时，都会耗费一定的时间，这是为什么呢？
        // 按理说，向桶中放入了5个令牌后，再从桶中获取令牌也应该和第一次一样并不会花费时间啊！
        // 因为在Guava的实现是这样的：我们使用RateLimiter.create(5)创建令牌桶对象时，
        // 表示每秒新增5个令牌，1秒等于1000毫秒，也就是每隔200毫秒向桶中放入一个令牌。
        // 当我们运行程序时，程序运行到RateLimiter limiter = RateLimiter.create(5);时，
        // 就会向桶中放入一个令牌，当程序运行到第一个System.out.println(limiter.acquire(1));时，
        // 由于桶中已经存在一个令牌，直接获取这个令牌，并没有花费时间。
        // 然而程序继续向下执行时，由于程序会每隔200毫秒向桶中放入一个令牌，所以，获取令牌时，花费的时间几乎都是200毫秒左右。

        // 作者：冰_河
        // 链接：https://juejin.im/post/6855129005742686215
        // 来源：掘金
        // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }

    /**
     * <br/> @Title: 突发流量
     * <br/> @MethodName:  guavaLimitTest2
     * <br/>
     * <br/> @Return void
     * <br/> @Description:
     * <br/> @author: 80004960
     * <br/> @date:  2020/8/16 16:40
     */
    private static void guavaLimitTest2() {
        //每秒钟生成5个令牌
        RateLimiter limiter = RateLimiter.create(5);

        // 0.0
        // 9.998242
        // 0.99842
        // 0.999669
        // 0.999352

        //返回值表示从令牌桶中获取一个令牌所花费的时间，单位是秒
        System.out.println(limiter.acquire(50));
        System.out.println(limiter.acquire(5));
        System.out.println(limiter.acquire(5));
        System.out.println(limiter.acquire(5));
        System.out.println(limiter.acquire(5));

        // 上述代码表示的含义为：每秒向桶中放入5个令牌，第一次从桶中获取50个令牌，
        // 也就是我们说的突发流量，后续每次从桶中获取5个令牌。接下来，我们运行上述代码看下效果。

        // 运行代码时，会发现当命令行打印出0.0后，会等很久才会打印出后面的输出结果。
        // 程序每秒钟向桶中放入5个令牌，当程序运行到 RateLimiter limiter = RateLimiter.create(5); 时，
        // 就会向桶中放入令牌。当运行到 System.out.println(limiter.acquire(50));
        // 时，发现很快就会获取到令牌，花费了0.0秒。
        // 接下来，运行到第一个System.out.println(limiter.acquire(5));时，花费了9.998409秒。
        // 小伙们可以思考下，为什么这里会花费10秒中的时间呢？
        // 这是因为我们使用RateLimiter limiter = RateLimiter.create(5);代码向桶中放入令牌时，一秒钟放入5个，
        // 而System.out.println(limiter.acquire(50));
        // 需要获取50个令牌，也就是获取50个令牌需要花费10秒钟时间，这是因为程序向桶中放入50个令牌需要10秒钟。
        // 程序第一次从桶中获取令牌时，很快就获取到了。而第二次获取令牌时，花费了将近10秒的时间。
        // Guava框架支持突发流量，但是在突发流量之后再次请求时，会被限速，
        // 也就是说：在突发流量之后，再次请求时，会弥补处理突发请求所花费的时间。
        // 所以，我们的突发示例程序中，在一次从桶中获取50个令牌后，再次从桶中获取令牌，则会花费10秒左右的时间。

    }
}