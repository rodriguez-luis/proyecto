package bo.ucb.edu.ingsoft.dto;

import bo.ucb.edu.ingsoft.model.Transaction;

import java.util.Date;

public class CheckoutDto {
    private Integer checkoutId;
    private Integer cartId;

    public Integer getPaymentDetailsId() {
        return paymentDetailsId;
    }

    public void setPaymentDetailsId(Integer paymentDetailsId) {
        this.paymentDetailsId = paymentDetailsId;
    }

    private Integer paymentDetailsId;
    private Date date;
    private Double total;
    private String contact;
    private String address;

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



    public CheckoutDto() {
    }

    public Integer getCheckoutId() {
        return checkoutId;
    }

    public void setCheckoutId(Integer checkoutId) {
        this.checkoutId = checkoutId;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
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


    @Override
    public String toString() {
        return "CheckoutDto{" +
                "checkoutId=" + checkoutId +
                ", cartId=" + cartId +
                ", paymentDetailsId=" + paymentDetailsId +
                ", date=" + date +
                ", total=" + total +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
