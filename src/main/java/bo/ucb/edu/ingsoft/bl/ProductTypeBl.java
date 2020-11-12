package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.ProductTypeDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.ProductTypeCreate;
import bo.ucb.edu.ingsoft.model.ProductType;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductTypeBl {
    private ProductTypeDao productTypeDao;
    private TransactionDao transactionDao;

    @Autowired
    public ProductTypeBl(ProductTypeDao productTypeDao, TransactionDao transactionDao) {
        this.productTypeDao = productTypeDao;
        this.transactionDao = transactionDao;
    }

    public ProductType findByProductTypeById (Integer productTypeId){
        return productTypeDao.findProductTypeById(productTypeId);}


    public ProductTypeCreate productTypeCreate(ProductTypeCreate productTypeCreate, Transaction transaction){
        productTypeCreate.setTxId(transaction.getTxId());
        productTypeCreate.setTxUserId(transaction.getTxUserId());
        productTypeCreate.setTxHost(transaction.getTxHost());
        productTypeCreate.setTxDate(transaction.getTxDate());
        productTypeDao.create(productTypeCreate);
        Integer getLastId = transactionDao.getLastInsertId();
        productTypeCreate.setProductTypeId(getLastId);
        return productTypeCreate;
    }
}
