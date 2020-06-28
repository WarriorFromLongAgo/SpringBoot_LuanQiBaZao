package com.xuegao.design_patterns.strategy;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * <br/> @PackageName：com.xuegao.design_patterns.strategy
 * <br/> @ClassName：MapStrategyPattern2
 * <br/> @Description：
 * <br/> @author：feijm
 * <br/> @date：2020/6/26 19:17
 */
public class MapStrategyPattern2 {
}

class BizUnitService {

    public String bizOne(String order) {
        return order + "各种花式操作1";
    }

    public String bizTwo(String order) {
        return order + "各种花式操作2";
    }

    public String bizThree(String order) {
        return order + "各种花式操作3";
    }
}

class BizService {

    private BizUnitService bizUnitService = new BizUnitService();

    private Map<String, Function<String, String>> checkResultDispatcherComX = new HashMap<>();

    /**
     * 初始化 业务逻辑分派Map 其中value 存放的是 lambda表达式
     */
    @PostConstruct
    public void checkResultDispatcherComXInit() {
        checkResultDispatcherComX.put("key_订单1", order -> bizUnitService.bizOne(order));
        checkResultDispatcherComX.put("key_订单1_订单2", order -> bizUnitService.bizTwo(order));
        checkResultDispatcherComX.put("key_订单1_订单2_订单3", order -> bizUnitService.bizThree(order));
    }

    public String getCheckResultComX(String order, int level) {
        //写一段生成key的逻辑：
        String ley = getDispatcherComXKey(order, level);

        Function<String, String> result = checkResultDispatcherComX.get(ley);
        if (result != null) {
            //执行这段表达式获得String类型的结果
            return result.apply(order);
        }
        return "不在处理的逻辑中返回业务错误";
    }

    /**
     * 判断条件方法
     */
    private String getDispatcherComXKey(String order, int level) {
        StringBuilder key = new StringBuilder("key");
        for (int i = 1; i <= level; i++) {
            key.append("_" + order + i);
        }
        return key.toString();
    }
}