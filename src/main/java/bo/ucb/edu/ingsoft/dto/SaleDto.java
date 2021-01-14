package bo.ucb.edu.ingsoft.dto;

import java.util.Date;

public class SaleDto {

    private Integer saleId;
    private Integer companyId;
    private String card;
    private String month;
    private Integer year;
    private Integer securityCode;

    private String name;
    private String phone;
    private String direction;
    private Double total;

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

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
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

    @Override
    public String toString() {
        return "SaleDto{" +
                "saleId=" + saleId +
                ", companyId=" + companyId +
                ", card=" + card +
                ", month=" + month + '\'' +
                ", year=" + year +
                ", securityCode=" + securityCode +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", direction='" + direction + '\'' +
                ", total=" + total +
                '}';
    }
}
