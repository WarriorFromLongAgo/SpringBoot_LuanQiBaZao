package com.xuegao.luanqibazao_1.utils.mail;

import java.util.List;
import java.util.Properties;

/**
 * <br/> @PackageName：com.xuegao.luanqibazao_1.mail
 * <br/> @ClassName：MailInfo
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/11/30 11:23
 */
public class MailInfo {
    private String mailServerHost;// 服务器ip
    private String mailServerPort = "25";// 端口,默认25
    private String fromAddress;// 发送者的邮件地址
    private Boolean validate = true;// 是否需要身份验证,默认需要
    private String username;// 登录邮件发送服务器的用户名
    private String password;// 登录邮件发送服务器的密码

    private List<String> recipientsTo;//邮件接收者地址
    private List<String> recipientsCc;//邮件抄送者地址
    private List<String> recipientsBcc;//邮件密送者地址
    private String subject;// 邮件主题
    private String content;// 邮件内容
    private boolean isHtml = true;//是否为HTML邮件
    private String[] attachFilePaths;// 附件地址

    private Properties mailProp;//邮件属性

    public MailInfo() {
        super();
    }

    /**
     * 加载并初始化基本邮件基本配置
     * @param p
     */
    public MailInfo(Properties p){
        this.mailServerHost = p.getProperty("mail.smtp.host");
        this.mailServerPort = p.getProperty("mail.smtp.port","25");
        this.fromAddress = p.getProperty("mail.sendfrom");
        this.validate = Boolean.valueOf(p.getProperty("mail.smtp.auth","true"));
        this.username = p.getProperty("mail.username");
        this.password = p.getProperty("mail.password");
        this.mailProp = p;
    }

    /**
     * 获取邮件配置
     * @return
     */
    public Properties getProperties() {
        if(this.mailProp != null){
            return getMailProp();
        }
        Properties p = new Properties();
        p.put("mail.smtp.host", this.mailServerHost);
        p.put("mail.smtp.port", this.mailServerPort);
        p.put("mail.smtp.auth", this.validate ? "true" : "false");
        p.put("mail.mime.charset", "utf-8");
        return p;
    }

    public String getMailServerHost() {
        return mailServerHost;
    }

    public void setMailServerHost(String mailServerHost) {
        this.mailServerHost = mailServerHost;
    }

    public String getMailServerPort() {
        return mailServerPort;
    }

    public void setMailServerPort(String mailServerPort) {
        this.mailServerPort = mailServerPort;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public List<String> getRecipientsTo() {
        return recipientsTo;
    }

    public void setRecipientsTo(List<String> recipientsTo) {
        this.recipientsTo = recipientsTo;
    }

    public List<String> getRecipientsCc() {
        return recipientsCc;
    }

    public void setRecipientsCc(List<String> recipientsCc) {
        this.recipientsCc = recipientsCc;
    }

    public List<String> getRecipientsBcc() {
        return recipientsBcc;
    }

    public void setRecipientsBcc(List<String> recipientsBcc) {
        this.recipientsBcc = recipientsBcc;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isHtml() {
        return isHtml;
    }

    public void setHtml(boolean isHtml) {
        this.isHtml = isHtml;
    }

    public String[] getAttachFilePaths() {
        return attachFilePaths;
    }

    public void setAttachFilePaths(String[] attachFileNames) {
        this.attachFilePaths = attachFileNames;
    }

    public Properties getMailProp() {
        return mailProp;
    }

    public void setMailProp(Properties mailProp) {
        this.mailProp = mailProp;
    }

}