package bo.ucb.edu.ingsoft.dto;

import java.util.Date;

public class ProductoReservaDto {

    //Datos de ProductoReserva
    private Integer prId;
    private Integer productId;
    private Integer checkoutId;
    private Integer cantidad;
    //Datos del producto
    private String productName;
    private String model;
    private String productDescription;
    private Integer stock;
    private Double weight;
    private Double unitPrice;
    private Integer currency;
    private String img;

    private Integer companyId;
    private Integer productTypeId;
    private Integer cityId;
    private Integer brandId;

    //Datos del Checkout Reserva
    private Date date;
    private Double total;
    private String contact;
    private String address;

    private Integer cartId;
    private Integer paymentDetailsId;




    public java.lang.String getImg() {
        return img;
    }
    public void setImg(java.lang.String img) {
        this.img = img;
    }

    public Integer getPrId() {
        return prId;
    }

    public void setPrId(Integer prId) {
        this.prId = prId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(Integer checkoutId) {
        this.checkoutId = checkoutId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
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

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getCurrency() {
        return currency;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //llaves foraneas
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

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getPaymentDetailsId() {
        return paymentDetailsId;
    }

    public void setPaymentDetailsId(Integer paymentDetailsId) {
        this.paymentDetailsId = paymentDetailsId;
    }

    @Override
    public String toString() {
        return "ProductoReservaDto{" +
                "prId=" + prId +
                ", productId=" + productId +
                ", checkoutId=" + checkoutId +
                ", cantidad=" + cantidad +
                ", productName='" + productName + '\'' +
                ", model='" + model + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", stock=" + stock +
                ", weight=" + weight +
                ", unitPrice=" + unitPrice +
                ", currency=" + currency +
                ", img='" + img + '\'' +
                ", companyId=" + companyId +
                ", productTypeId=" + productTypeId +
                ", cityId=" + cityId +
                ", brandId=" + brandId +
                ", date=" + date +
                ", total=" + total +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                ", cartId=" + cartId +
                ", paymentDetailsId=" + paymentDetailsId +
                '}';
    }
}
