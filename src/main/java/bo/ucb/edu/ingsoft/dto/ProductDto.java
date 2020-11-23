package bo.ucb.edu.ingsoft.dto;

import bo.ucb.edu.ingsoft.model.Transaction;

import java.util.Date;

public class ProductDto {
    private Integer productId;
    private String productName;
    private String model;
    private String productDescription;
    private Integer stock;
    private Double weight;
    private Integer companyId;
    private Integer productTypeId;
    private Integer cityId;
    private Double unitPrice;
    private Integer currency;
    private Integer brandId;
    public Integer getCurrency() {
        return currency;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }
    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", model='" + model + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", stock=" + stock +
                ", weight=" + weight +
                ", CompanyId=" + companyId +
                ", productTypeId=" + productTypeId +
                ", cityId=" + cityId +
                ", unitPrice=" + unitPrice +
                ", currency=" + currency +
                ", brandId=" + brandId +
                '}';
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }
}
