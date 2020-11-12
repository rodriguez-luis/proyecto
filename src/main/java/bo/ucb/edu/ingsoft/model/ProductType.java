package bo.ucb.edu.ingsoft.model;

import java.util.Date;

public class ProductType {
    private Integer productTypeId;
    private String type_name;
    private Transaction transaction;
    private Integer status;
    public ProductType(Integer productTypeId, String type_name, Integer txId, String txHost, Integer txUserId, Date txDate, Integer status) {
        this.productTypeId = productTypeId;
        this.type_name = type_name;
        this.status = status;
        this.transaction = new Transaction(txId,txHost,txUserId,txDate);
    }

    public ProductType(){
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "ProductType{" +
                "productTypeId=" + productTypeId +
                ", type_name='" + type_name + '\'' +
                ", transaction=" + transaction +
                ", status=" + status +
                '}';
    }
}