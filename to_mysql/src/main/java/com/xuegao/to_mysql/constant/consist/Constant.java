package com.xuegao.to_mysql.constant.consist;

/**
 * @PackageName：com.fff.springbooto.constant
 * @ClassName：
 * @Description：
 * @author：
 * @date：2020/1/10 15:50
 */
public class Constant {

    public interface RedisConstant {

        String OK = "OK";
        // 过期时间, 60s, 一分钟
        Integer EXPIRE_TIME_MINUTE = 60;
        // 过期时间, 600s, 十分钟
        Integer EXPIRE_TIME_TEN_MINUTE = 60 * 10;
        // 过期时间, 一小时
        Integer EXPIRE_TIME_HOUR = 60 * 60;
        // 过期时间, 半天
        Integer EXPIRE_TIME_HALF_DAY = 60 * 60 * 12;
        // 过期时间, 一天
        Integer EXPIRE_TIME_DAY = 60 * 60 * 24;
        // token 头
        String TOKEN_PREFIX = "token:";
        // 消息消费者前缀
        String MESSAGE_CONSUMER_PREFIX = "consumer:";
        // 访问限制前缀
        String ACCESS_LIMIT_PREFIX = "accessLimit:";
    }

    public interface LogType {
        Integer LOGIN = 1;// 登录
        Integer LOGOUT = 2;// 登出
    }

    public interface MessageLogStatus {
        Integer DELIVERING = 0;// 消息投递中
        Integer DELIVER_SUCCESS = 1;// 投递成功
        Integer DELIVER_FAIL = 2;// 投递失败
        Integer CONSUMED_SUCCESS = 3;// 已消费
    }
}
