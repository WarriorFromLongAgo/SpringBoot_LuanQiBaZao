package com.xuegao.luanqibazao_1.domain;

import java.io.Serializable;

/**
 * <br/> @PackageName：com.sf.module.train.domain
 * <br/> @ClassName：RequestV1DTO
 * <br/> @Description：专门用于 谁 修改 谁，从什么修改成什么的情况下使用
 * <br/> @author：
 * <br/> @date：2020/7/30 13:51
 * <br/> @version：V1
 */
public class RequestV1DTO implements Serializable {

    private static final long serialVersionUID = 8556015294297512107L;
    // 来源
    private String source;
    // 去向
    private String target;

    private Object value;

    public RequestV1DTO() {
    }

    @Override
    public String toString() {
        return "RequestV1DTO {" +
                "source='" + source + '\'' +
                ", target='" + target + '\'' +
                ", value=" + value +
                '}';
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}