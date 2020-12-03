// package com.xuegao.luanqibazao_1.mail;
//
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.context.annotation.Configuration;
//
// import javax.activation.DataHandler;
// import javax.activation.FileDataSource;
// import java.io.*;
// import java.util.Date;
// import java.util.List;
// import java.util.Map;
// import java.util.Properties;
//
// /**
//  * <br/> @PackageName：com.xuegao.luanqibazao_1.mail
//  * <br/> @ClassName：MailUtil
//  * <br/> @Description：
//  * <br/> @author：xuegao
//  * <br/> @date：2020/11/30 11:24
//  */
// public class MailUtil {
//     private MailUtil() {}
//
//     private static Configuration config = null;
//
//     private static final Logger logger = LoggerFactory
//             .getLogger(MailUtil.class);
//
//     /**
//      * 发送单封邮件
//      * @param mailInfo
//      * @return
//      */
//     public static MailSendResult sendMail(MailInfo mailInfo) {
//         Session session = createSession(mailInfo);
//         return sendMail(mailInfo, session);
//     }
//
//     /**
//      * 发送邮件
//      * @param mailInfo
//      * @param session
//      * @return
//      */
//     public static MailSendResult sendMail(MailInfo mailInfo, Session session) {
//
//         MailSendResult mailSendResult = null;
//         try {
//             Message mailMessage;
//             if(mailInfo.isHtml()){
//                 //创建HTML格式邮件消息体
//                 mailMessage = createHtmlMessage(mailInfo, session);
//             }else{
//                 //创建普通文本格式邮件消息体
//                 mailMessage = createTextMessage(mailInfo, session);
//             }
//             //发送邮件
//             Transport.send(mailMessage);
//         } catch (Exception e) {
//             mailSendResult = new MailSendResult(e);
//         }
//         if(mailSendResult == null){
//             mailSendResult = new MailSendResult();
//         }
//         return mailSendResult;
//     }
//
//     /**
//      * @return
//      * @throws IOException
//      */
//     public static MailInfo creatMailInfo(String mailPropPath) {
//         String confPath = System.getenv("CONF_PATH");
//         Properties mailProp = new Properties();
//         FileInputStream fin = null;
//         MailInfo mailInfo = null;
//         try {
//             fin = new FileInputStream(confPath+mailPropPath);
//             InputStream in = new BufferedInputStream(fin);
//             mailProp.load(in);
//             //邮件基本配置构造
//             mailInfo = new MailInfo(mailProp);
//         } catch (Exception e) {
//             logger.error("获取邮件配置失败：", e);
//         } finally {
//             IOUtils.closeQuietly(fin);
//         }
//         return mailInfo;
//     }
//
//     /**
//      * 构造发送邮件session
//      * @param mailInfo
//      * @return
//      */
//     public static Session createSession(MailInfo mailInfo) {
//         //判断是否需要身份认证
//         CustomAuthenticator authenticator = null;
//         Properties properties = mailInfo.getProperties();
//         if (mailInfo.isValidate()) {
//             // 如果需要身份认证，则创建一个密码验证器
//             authenticator = new CustomAuthenticator(mailInfo.getUsername(), mailInfo.getPassword());
//         }
//         // 根据邮件会话属性和密码验证器构造一个发送邮件的session
//         Session sendMailSession = Session.getDefaultInstance(properties, authenticator);
//         return sendMailSession;
//     }
//
//     /**
//      * 构造普通文本消息体
//      * @param mailInfo
//      * @param sendMailSession
//      * @return
//      * @throws MessagingException
//      */
//     public static Message createTextMessage(MailInfo mailInfo, Session sendMailSession)
//             throws MessagingException {
//         //MimeMultipart类是一个容器类，包含MimeBodyPart类型的对象
//         Multipart mainPart = createTextMultipart(mailInfo.getContent());
//         return createMessage(mailInfo, sendMailSession, mainPart);
//     }
//
//     /**
//      * 构造HTML消息体
//      * @param mailInfo
//      * @param sendMailSession
//      * @return
//      * @throws MessagingException
//      */
//     public static Message createHtmlMessage(MailInfo mailInfo, Session sendMailSession)
//             throws MessagingException {
//         //MimeMultipart类是一个容器类，包含MimeBodyPart类型的对象
//         Multipart mainPart = createHtmlMultipart(mailInfo.getContent());
//         return createMessage(mailInfo, sendMailSession, mainPart);
//     }
//
//     /**
//      * 创建消息主体
//      * @param mailInfo
//      * @param sendMailSession
//      * @return
//      * @throws MessagingException
//      */
//     private static Message createMessage(MailInfo mailInfo,
//                                          Session sendMailSession, Multipart mainPart) throws MessagingException {
//         Message mailMessage = new MimeMessage(sendMailSession);//根据session创建一个邮件消息
//         if(mailInfo.getFromAddress() != null){
//             Address from = new InternetAddress(mailInfo.getFromAddress());//创建邮件发送者地址
//             mailMessage.setFrom(from);//设置邮件消息的发送者
//         }
//         //设置接收者
//         setMessageRecipients(mailMessage, mailInfo.getRecipientsTo(),mailInfo.getRecipientsCc(),mailInfo.getRecipientsBcc());
//         mailMessage.setSubject(mailInfo.getSubject());//设置邮件消息的主题
//         mailMessage.setSentDate(new Date());//设置邮件消息发送的时间
//
//         //消息主体中添加附件
//         addAttachFiles(mainPart, mailInfo.getAttachFilePaths());
//
//         //将MimeMultipart对象设置为邮件内容
//         mailMessage.setContent(mainPart);
//         return mailMessage;
//     }
//
//     /**
//      * 构造普通文本消息主体
//      * @param content
//      * @param attachFilePaths
//      * @return
//      * @throws MessagingException
//      */
//     public static Multipart createTextMultipart(String content)
//             throws MessagingException {
//
//         //MimeMultipart类是一个容器类，包含MimeBodyPart类型的对象
//         Multipart mainPart = new MimeMultipart();
//         MimeBodyPart messageBodyPart = new MimeBodyPart();//创建一个文本内容的MimeBodyPart
//         //设置文本内容
//         messageBodyPart.setText(content, "utf-8");
//         mainPart.addBodyPart(messageBodyPart);
//
//         return mainPart;
//     }
//
//     /**
//      * 构造HTML消息主体
//      * @param mailInfo
//      * @return
//      * @throws MessagingException
//      */
//     private static Multipart createHtmlMultipart(String content)
//             throws MessagingException {
//         Multipart mainPart = new MimeMultipart();
//         MimeBodyPart messageBodyPart = new MimeBodyPart();//创建一个包含HTML内容的MimeBodyPart
//         //设置HTML内容
//         messageBodyPart.setContent(content,"text/html; charset=utf-8");
//         mainPart.addBodyPart(messageBodyPart);
//
//         return mainPart;
//     }
//
//     /**
//      * 主体中增加附件
//      * @param attachFilePaths
//      * @param mainPart
//      * @throws MessagingException
//      */
//     public static void addAttachFiles(Multipart mainPart,
//                                       String[] attachFilePaths) throws MessagingException {
//         //存在附件
//         if (attachFilePaths != null && attachFilePaths.length > 0) {
//             for(String filePath:attachFilePaths){
//                 MimeBodyPart attachBodyPart = new MimeBodyPart();
//                 File file = new File(filePath);
//                 if(file.exists()){//附件存在磁盘中
//                     FileDataSource fds = new FileDataSource(file);//得到数据源
//                     attachBodyPart.setDataHandler(new DataHandler(fds));//得到附件本身并至入BodyPart
//                     attachBodyPart.setFileName(file.getName());//得到文件名同样至入BodyPart
//                     mainPart.addBodyPart(attachBodyPart);
//                 }
//             }
//         }
//     }
//
//     /**
//      * 设置邮件接受者
//      * @param mailMessage 消息
//      * @param recipientsTo 接收者
//      * @param recipientsCc 抄送者
//      * @param recipientsBcc 密送者
//      * @throws MessagingException
//      */
//     public static Message setMessageRecipients(Message mailMessage, List<String> recipientsTo, List<String> recipientsCc, List<String> recipientsBcc)
//             throws MessagingException {
//         if(recipientsTo != null && !recipientsTo.isEmpty() ){
//             int toSize = recipientsTo.size();
//             InternetAddress[] addresses = new InternetAddress[toSize];
//             for (int i = 0; i < toSize; i++) {
//                 addresses[i] = new InternetAddress(recipientsTo.get(i));
//             }
//             mailMessage.setRecipients(Message.RecipientType.TO, addresses);//设置邮件消息的接收者
//         }
//         if(recipientsCc != null && !recipientsCc.isEmpty() ){
//             int ccSize = recipientsCc.size();
//             InternetAddress[] addresses = new InternetAddress[ccSize];
//             for (int i = 0; i < ccSize; i++) {
//                 addresses[i] = new InternetAddress(recipientsCc.get(i));
//             }
//             mailMessage.setRecipients(Message.RecipientType.CC, addresses);//设置邮件消息的抄送者
//         }
//         if(recipientsBcc != null && !recipientsBcc.isEmpty() ){
//             int bccSize = recipientsBcc.size();
//             InternetAddress[] addresses = new InternetAddress[bccSize];
//             for (int i = 0; i < bccSize; i++) {
//                 addresses[i] = new InternetAddress(recipientsBcc.get(i));
//             }
//             mailMessage.setRecipients(Message.RecipientType.BCC, addresses);//设置邮件消息的密送者
//         }
//         return mailMessage;
//     }
//
//     /**
//      * 混合邮件模板生成内容
//      * @param templatePath
//      * @param templateName
//      * @param root
//      * @param encoding
//      * @return
//      */
//     public static String mergeMailTemplate(String templatePath,
//                                            String templateName, Map<String, Object> root, String encoding) {
//         try {
//             StringWriter out = new StringWriter();
//
//             if(config == null){
//                 config = new Configuration();
//                 // 设置要解析的模板所在的目录，并加载模板文件
//                 config.setDirectoryForTemplateLoading(new File(templatePath));
//                 // 设置包装器，并将对象包装为数据模型
//                 config.setObjectWrapper(new DefaultObjectWrapper());
//                 //模板缓存为1小时
//                 config.setTemplateUpdateDelay(60*60);
//                 config.setDateTimeFormat("yyyy年MM月dd日 HH:mm:ss");
//                 config.setDateFormat("yyyy年MM月dd日");
//             }
//
//             // 获取模板,并设置编码方式
//             Template template = config.getTemplate(templateName, encoding);
//
//             // template.process(root,out);
//             template.process(root, out);
//             out.flush();
//             IOUtils.closeQuietly(out);
//             return out.toString();
//         } catch (Exception e) {
//             logger.error("读取邮件模板失败", e);
//         }
//         return null;
//     }
//
// }