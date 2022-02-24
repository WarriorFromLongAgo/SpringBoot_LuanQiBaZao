package com.xuegao.design_patterns.xingwei.chain.file;

/**
 * @author xuegao
 * @version 1.0
 * @date 2022/2/24 0:12
 */
public class FileRequest {
    private String area;

    private String sectionKey;

    private String amount;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSectionKey() {
        return sectionKey;
    }

    public void setSectionKey(String sectionKey) {
        this.sectionKey = sectionKey;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}