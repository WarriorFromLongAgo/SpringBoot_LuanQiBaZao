package com.xuegao.luanqibazao_1.tools.JsonAreaDuplicate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PeerOffer {

    private Integer id;
    /**
     * 字段名称：始发区号
     * <p>
     * 数据库字段信息:begin_area_code VARCHAR(512)
     */
    private String beginAreaCode;

    /**
     * 字段名称：目的区号
     * <p>
     * 数据库字段信息:end_area_code VARCHAR(512)
     */
    private String endAreaCode;
}
