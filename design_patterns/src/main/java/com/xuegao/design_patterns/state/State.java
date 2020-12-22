package com.xuegao.design_patterns.state;

/**
 * <br/> @PackageName：com.xuegao.design_patterns.state
 * <br/> @ClassName：State
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/12/22 10:02
 */
public interface State {

    public abstract void doClock(Context context,int hour);
    public abstract void doUse(Context context);
    public abstract void doAlarm(Context context);
    public abstract void doPhone(Context context);
}