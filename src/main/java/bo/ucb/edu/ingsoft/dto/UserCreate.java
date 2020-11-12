package bo.ucb.edu.ingsoft.dto;

import bo.ucb.edu.ingsoft.model.Transaction;

import java.util.Date;

public class UserCreate {
    /*{
       "firstName": "Juanito",
       "lastName": "Prueba",
       "username": "juanprueba",
       "password": "prueba",
       "companyId": 1,
       "city": 1,
       "phone": "77747774",
       "email": "jprueba@gmail.com"
       "birthday: "1997-08-15"
    }*/

    private Integer userId;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Integer companyId;
    private Integer cityId;
    private String phone;
    private String email;
    private Date birthDate;
    private Transaction transaction;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public UserCreate(){
        this.transaction= new Transaction();
    }

    public Integer getTxId() {
        return this.transaction.getTxId();
    }

    public void setTxId(Integer txId) {
        this.transaction.setTxId(txId);
    }

    public String getTxHost() {
        return this.transaction.getTxHost();
    }

    public void setTxHost(String txHost) {
        this.transaction.setTxHost(txHost);
    }

    public Integer getTxUserId() {
        return this.transaction.getTxUserId();
    }

    public void setTxUserId(Integer txUserId) {
        this.transaction.setTxUserId(txUserId);
    }

    public Date getTxDate() {
        return this.transaction.getTxDate();
    }

    public void setTxDate(Date txDate) {
        this.transaction.setTxDate(txDate);
    }

    @Override
    public String toString() {
        return "UserCreate{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", companyId=" + companyId +
                ", cityId=" + cityId +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                ", transaction=" + transaction +
                '}';
    }
}
