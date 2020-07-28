package com.xuegao.design_patterns.strategy;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * <br/> @PackageName：com.xuegao.design_patterns.strategy
 * <br/> @ClassName：MapStrategyPattern
 * <br/> @Description：map方法代替策略方法
 * <br/> @author：xuegao
 * <br/> @date：2020/6/26 19:14
 */
public class MapStrategyPattern {

    private Map<String, Function<String, String>> checkResultDispatcherMuti = new HashMap<>();

    /**
     * 初始化 业务逻辑分派Map 其中value 存放的是 lambda表达式
     */
    @PostConstruct
    public void checkResultDispatcherMuitInit() {
        checkResultDispatcherMuti.put("key_订单1", order -> String.format("对%s执行业务逻辑1", order));
        checkResultDispatcherMuti.put("key_订单1", new Function<String, String>() {
            @Override
            public String apply(String order) {
                return String.format("对%s执行业务逻辑1", order);
            }
        });
        checkResultDispatcherMuti.put("key_订单1_订单2", order -> String.format("对%s执行业务逻辑2", order));
        checkResultDispatcherMuti.put("key_订单1_订单2_订单3", order -> String.format("对%s执行业务逻辑3", order));
    }

    public String getCheckResultMuti(String order, int level) {
        //写一段生成key的逻辑：
        String ley = getDispatcherKey(order, level);

        Function<String, String> result = checkResultDispatcherMuti.get(ley);
        if (result != null) {
            //执行这段表达式获得String类型的结果
            return result.apply(order);
        }
        return "不在处理的逻辑中返回业务错误";
    }

    /**
     * 判断条件方法
     */
    private String getDispatcherKey(String order, int level) {
        StringBuilder key = new StringBuilder("key");
        for (int i = 1; i <= level; i++) {
            key.append("_")
                    .append(order)
                    .append(i);
        }
        return key.toString();
    }
}