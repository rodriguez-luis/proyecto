package bo.ucb.edu.ingsoft.model;

import java.util.Date;

public class ProductoReserva {

    private Integer prId;
    private Integer productId;
    private Integer checkoutId;
    private Integer cantidad;
    private Integer status;
    private Transaction transaction;



    public ProductoReserva() {
        this.transaction= new Transaction();
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
        return "ProductoReserva{" +
                "prId=" + prId +
                ", productId=" + productId +
                ", checkoutId=" + checkoutId +
                ", cantidad=" + cantidad +
                ", txId=" + transaction.getTxId() +
                ", txHost='" + transaction.getTxHost() + '\'' +
                ", txUserId=" + transaction.getTxUserId() +
                ", txDate=" + transaction.getTxDate() +
                '}';
    }
}
