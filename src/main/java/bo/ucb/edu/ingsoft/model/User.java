package bo.ucb.edu.ingsoft.model;

import java.util.Date;

public class User {
    private Integer userId;
    private Integer personId;
    private Integer companyId;
    private Integer statusId;
    private String username;
    private String password;
    private String salt;
    private Integer token;
    private Transaction transaction;

    public User(Integer userId, Integer personId, Integer companyId, Integer statusId, String username, String password, String salt, Integer token, Integer txId, String txHost, Integer txUserId, Date txDate) {
        this.userId = userId;
        this.personId = personId;
        this.companyId = companyId;
        this.statusId = statusId;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.token = token;
        this.transaction =new Transaction(txId,txHost,txUserId,txDate);
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getToken() {
        return token;
    }

    public void setToken(Integer token) {
        this.token = token;
    }

    public Integer getTxId() {
        return transaction.getTxId();
    }

    public void setTxId(Integer txId) {
        this.transaction.setTxId(txId);
    }

    public String getTxHost() {
        return transaction.getTxHost();
    }

    public void setTxHost(String txHost) {
        this.transaction.setTxHost(txHost);
    }

    public Integer getTxUserId() {
        return transaction.getTxUserId();
    }

    public void setTxUserId(Integer txUserId) {
        this.transaction.setTxUserId(txUserId);
    }

    public Date getTxDate() {
        return transaction.getTxDate();
    }

    public void setTxDate(Date txDate) {
        this.transaction.setTxDate(txDate);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", personId=" + personId +
                ", companyId=" + companyId +
                ", statusId=" + statusId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", token=" + token +
                ", txId=" + transaction.getTxId() +
                ", txHost='" + transaction.getTxHost() + '\'' +
                ", txUserId=" + transaction.getTxUserId() +
                ", txDate=" + transaction.getTxDate() +
                '}';
    }
}
