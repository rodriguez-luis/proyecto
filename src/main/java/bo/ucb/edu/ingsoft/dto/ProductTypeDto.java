package bo.ucb.edu.ingsoft.dto;

import bo.ucb.edu.ingsoft.model.Transaction;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

public class ProductTypeDto {
    /*{
       "typename": "MotherBoard"
   }*/
    private Integer productTypeId;
    @NotEmpty
    @Size(min = 1, max = 10)
    private String typeName;
    //private Integer statusId;
    //private Transaction transaction;

    @Override
    public String toString() {
        return "ProductTypeDto{" +
                "productTypeId=" + productTypeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;

    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

//    public Integer getStatusId() {
//        return statusId;
//    }
//
//    public void setStatusId(Integer statusId) {
//        this.statusId = statusId;
//    }
//
//    public Transaction getTransaction() {
//        return transaction;
//    }
//
//    public void setTransaction(Transaction transaction) {
//        this.transaction = transaction;
//    }
//
//    public ProductTypeDto(){
//        this.transaction= new Transaction();
//    }
//
//    public Integer getTxId() {
//        return this.transaction.getTxId();
//    }
//
//    public void setTxId(Integer txId) {
//        this.transaction.setTxId(txId);
//    }
//
//    public String getTxHost() {
//        return this.transaction.getTxHost();
//    }
//
//    public void setTxHost(String txHost) {
//        this.transaction.setTxHost(txHost);
//    }
//
//    public Integer getTxUserId() {
//        return this.transaction.getTxUserId();
//    }
//
//    public void setTxUserId(Integer txUserId) {
//        this.transaction.setTxUserId(txUserId);
//    }
//
//    public Date getTxDate() {
//        return this.transaction.getTxDate();
//    }
//
//    public void setTxDate(Date txDate) {
//        this.transaction.setTxDate(txDate);
//    }
}
