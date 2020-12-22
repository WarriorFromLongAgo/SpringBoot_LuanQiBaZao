package com.xuegao.design_patterns.state;

/**
 * <br/> @PackageName：com.xuegao.design_patterns.state
 * <br/> @ClassName：Context
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/12/22 10:01
 */
public interface Context {
    public abstract void setClock(int hour);
    public abstract void changeState(State state);
    public abstract void callSecurity(String str);
    public abstract void recordLog(String msg);
}