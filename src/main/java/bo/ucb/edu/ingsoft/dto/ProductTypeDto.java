package bo.ucb.edu.ingsoft.dto;

import bo.ucb.edu.ingsoft.model.Transaction;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Service
public class ProductTypeDto {
    /*{
       "typename": "MotherBoard"
   }*/
    @NotEmpty(message = "el camno no debe de estar vacio")
    private Integer productTypeId;
    @NotEmpty(message = "el campo debe ser llenado correctamente")
    private String typeName;
    //private Integer statusId;
    //private Transaction transaction;

    public ProductTypeDto (){}

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
