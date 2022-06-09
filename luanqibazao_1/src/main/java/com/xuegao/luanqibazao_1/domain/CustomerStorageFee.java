package com.xuegao.luanqibazao_1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class CustomerStorageFee implements Serializable {
    private static final long serialVersionUID = 1L;


    private Integer id;
    /**
     * 数据库字段信息:month CHAR(7)
     */
    private String month;

    /**
     * 字段名称：客户id
     * <p>
     * 数据库字段信息:customer_id INT(10)
     */
    private Integer customerId;

    /**
     * 字段名称：客户编码
     */
    private Integer customerNumber;

    /**
     * 字段名称：合同编码
     * <p>
     * 数据库字段信息:contract_number VARCHAR(32)
     */
    private String contractNumber;

    /**
     * 字段名称：场地编码
     * <p>
     * 数据库字段信息:storage_number VARCHAR(32)
     */
    private String storageNumber;

    /**
     * 字段名称：单据编码
     * <p>
     * 数据库字段信息:oa_number VARCHAR(32)
     */
    private String oaNumber;

    /**
     * 字段名称：月租金
     * <p>
     * 数据库字段信息:monthly_rent DECIMAL(12,4)
     */
    private BigDecimal monthlyRent;

    /**
     * 字段名称：地仓储费。月租金基础上上浮20%
     * <p>
     * 数据库字段信息:storage_fee DECIMAL(12,4)
     */
    private BigDecimal storageFee;

    /**
     * 字段名称：申请人ID
     * <p>
     * 数据库字段信息:apply_id BIGINT(19)
     */
    private Long applyId;

    /**
     * 字段名称：申请人姓名
     * <p>
     * 数据库字段信息:apply_name VARCHAR(32)
     */
    private String applyName;

    /**
     * 字段名称：审批通过时间
     * <p>
     * 数据库字段信息:apply_audit_time DATETIME(19)
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp applyAuditTime;

    public CustomerStorageFee() {
    }

    @Override
    public String toString() {
        return "CustomerStorageFee{" +
                "month='" + month + '\'' +
                ", customerId=" + customerId +
                ", customerNumber=" + customerNumber +
                ", contractNumber='" + contractNumber + '\'' +
                ", storageNumber='" + storageNumber + '\'' +
                ", oaNumber='" + oaNumber + '\'' +
                ", monthlyRent=" + monthlyRent +
                ", storageFee=" + storageFee +
                ", applyId=" + applyId +
                ", applyName='" + applyName + '\'' +
                ", applyAuditTime=" + applyAuditTime +
                ", id=" + id +
                '}';
    }

    public String getMonth() {
        return this.month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getContractNumber() {
        return this.contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getStorageNumber() {
        return this.storageNumber;
    }

    public void setStorageNumber(String storageNumber) {
        this.storageNumber = storageNumber;
    }

    public String getOaNumber() {
        return this.oaNumber;
    }

    public void setOaNumber(String oaNumber) {
        this.oaNumber = oaNumber;
    }

    public BigDecimal getMonthlyRent() {
        return this.monthlyRent;
    }

    public void setMonthlyRent(BigDecimal monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public BigDecimal getStorageFee() {
        return this.storageFee;
    }

    public void setStorageFee(BigDecimal storageFee) {
        this.storageFee = storageFee;
    }

    public Long getApplyId() {
        return this.applyId;
    }

    public void setApplyId(Long applyId) {
        this.applyId = applyId;
    }

    public String getApplyName() {
        return this.applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    public Timestamp getApplyAuditTime() {
        return this.applyAuditTime;
    }

    public void setApplyAuditTime(Timestamp applyAuditTime) {
        this.applyAuditTime = applyAuditTime;
    }

    public Integer getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(Integer customerNumber) {
        this.customerNumber = customerNumber;
    }
}