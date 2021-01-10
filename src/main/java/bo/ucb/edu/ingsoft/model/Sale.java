package bo.ucb.edu.ingsoft.model;

import java.util.Date;

public class Sale {

    private Integer saleId;
    private Integer companyId;
    private Integer card;
    private Date expirationDate;
    private Integer securityCode;

    private String name;
    private String phone;
    private String direction;
    private Double total;

    private Transaction transaction;
    private Integer status;


    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCard() {
        return card;
    }

    public void setCard(Integer card) {
        this.card = card;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(Integer securityCode) {
        this.securityCode = securityCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    //transaction and status
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public Sale() {
        this.transaction= new Transaction();
    }

    @Override
    public String toString() {
        return "Sale{" +
                "saleId=" + saleId +
                ", companyId=" + companyId +
                ", card=" + card +
                ", expirationDate=" + expirationDate +
                ", securityCode=" + securityCode +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", direction='" + direction + '\'' +
                ", total=" + total +
                ", txId=" + transaction.getTxId() +
                ", txHost='" + transaction.getTxHost() + '\'' +
                ", txUserId=" + transaction.getTxUserId() +
                ", txDate=" + transaction.getTxDate() +
                '}';
    }
}
