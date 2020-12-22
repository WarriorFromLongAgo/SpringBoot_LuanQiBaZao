package com.xuegao.design_patterns.state;

/**
 * <br/> @PackageName：com.xuegao.design_patterns.state
 * <br/> @ClassName：NightState
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/12/22 10:05
 */
public class NightState implements State {
    private NightState() {

    }

    private static NightState nightState = new NightState();

    public static NightState getInstance() {
        return nightState;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (hour >= 6 && hour < 18) {
            //白天
            context.changeState(DayState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.callSecurity("晚上使用");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurity("晚上警铃");
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("晚上打电话");
    }
}