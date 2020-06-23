package com.xuegao.to_mysql.domain.po;

/**
 * <br/> @PackageName：com.xuegao.to_mysql.domain.po
 * <br/> @ClassName：TUserInfo
 * <br/> @Description：
 * <br/> @author：花名：xuegao
 * <br/> @date：2020/6/23 15:30
 */
public class TUserInfo {
    private Long id;
    private String userName;
    private String accountName;
    private String passWord;
    private Long idCard;

    public TUserInfo() {
    }

    public TUserInfo(Long id, String userName, String accountName, String passWord, Long idCard) {
        this.id = id;
        this.userName = userName;
        this.accountName = accountName;
        this.passWord = passWord;
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "TUserInfo {" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", accountName='" + accountName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", idCard=" + idCard +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Long getIdCard() {
        return idCard;
    }

    public void setIdCard(Long idCard) {
        this.idCard = idCard;
    }
}