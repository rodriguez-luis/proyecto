package bo.ucb.edu.ingsoft.model;



import org.springframework.stereotype.Service;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.Date;
public class ProductType {

    private Integer productTypeId;
    @Size(min = 3, max = 15)
    //@NotBlank (message = "el campo debe ser llenado correctamente")
    private String typeName;
    private Transaction transaction;
    private Integer status;


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
//    public ProductType(Integer productTypeId, String type_name, Integer txId, String txHost, Integer txUserId, Date txDate, Integer status) {
//        this.productTypeId = productTypeId;
//        this.typeName = type_name;
//        this.status = status;
//        this.transaction = new Transaction(txId,txHost,txUserId,txDate);
//    }

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

    public Integer getProductTypeId() {
        System.out.println(productTypeId);
        if (productTypeId == null){
            return 0;
        }
        else{
        return productTypeId;}
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getType_name() {
        return typeName;
    }

    public void setType_name(String type_name) {
        this.typeName = type_name;
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
                ", type_name='" + typeName + '\'' +
                ", status=" + status +
                ", txId=" + transaction.getTxId() +
                ", txHost='" + transaction.getTxHost() + '\'' +
                ", txUserId=" + transaction.getTxUserId() +
                ", txDate=" + transaction.getTxDate() +
                '}';
    }
}
