package com.xuegao.luanqibazao_1.utils.mail;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.mail
 * <br/> @ClassName：MailSendResult
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/11/30 11:24
 */
public class MailSendResult {

    /* 发送成功 */
    public static final Integer STATUS_SUCESS = 1;
    /* 发送失败 */
    public static final Integer STATUS_FAIL = 2;
    /* 发送部分失败 */
    public static final Integer STATUS_FAIL_PARTIAL = 3;
    //
    // /**
    //  * 原始邮件异常
    //  */
    // private Exception orignalException;
    //
    // /**
    //  * 无效地址
    //  */
    // private Address [] invalid;
    //
    // /**
    //  * 有效成功发送地址
    //  */
    // private Address[] validSent;
    //
    // /**
    //  * 有效未成功发送地址
    //  */
    // private Address [] validUnsent;
    //
    // private Integer status = STATUS_SUCESS;
    //
    // public MailSendResult() {
    //     super();
    // }
    //
    // public MailSendResult(Exception e) {
    //     if(e != null){
    //         setStatus(STATUS_FAIL);
    //         this.setOrignalException(e);
    //         if(e instanceof SendFailedException){
    //             SendFailedException sendFailException = (SendFailedException) e;
    //             this.invalid = sendFailException.getInvalidAddresses();
    //             this.validSent = sendFailException.getValidSentAddresses();
    //             this.validUnsent = sendFailException.getValidUnsentAddresses();
    //             if(this.validSent == null || this.validSent.length == 0){
    //                 setStatus(STATUS_FAIL);
    //             }else if(this.validUnsent != null && this.validUnsent.length >0){
    //                 setStatus(STATUS_FAIL_PARTIAL);
    //             }else if(this.invalid != null && this.invalid.length >0){
    //                 setStatus(STATUS_FAIL_PARTIAL);
    //             }else{
    //                 setStatus(STATUS_SUCESS);
    //             }
    //         }
    //     }else{
    //         setStatus(STATUS_SUCESS);
    //     }
    //
    // }
    //
    // public Exception getOrignalException() {
    //     return orignalException;
    // }
    //
    // public void setOrignalException(Exception orignalException) {
    //     this.orignalException = orignalException;
    // }
    //
    // public Address[] getInvalid() {
    //     return invalid;
    // }
    //
    // public void setInvalid(Address[] invalid) {
    //     this.invalid = invalid;
    // }
    //
    // public Address[] getValidSent() {
    //     return validSent;
    // }
    //
    // public void setValidSent(Address[] validSent) {
    //     this.validSent = validSent;
    // }
    //
    // public Address[] getValidUnsent() {
    //     return validUnsent;
    // }
    //
    // public void setValidUnsent(Address[] validUnsent) {
    //     this.validUnsent = validUnsent;
    // }
    //
    // public Integer getStatus() {
    //     return status;
    // }
    //
    // public void setStatus(Integer status) {
    //     this.status = status;
    // }
}