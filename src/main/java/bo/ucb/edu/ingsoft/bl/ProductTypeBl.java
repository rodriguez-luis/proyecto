package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.ProductTypeDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.ProductTypeDto;
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


    public ProductTypeDto productTypeCreate(ProductTypeDto productTypeDto, Transaction transaction){
        productTypeDto.setTxId(transaction.getTxId());
        productTypeDto.setTxUserId(transaction.getTxUserId());
        productTypeDto.setTxHost(transaction.getTxHost());
        productTypeDto.setTxDate(transaction.getTxDate());
        productTypeDao.create(productTypeDto);
        Integer getLastId = transactionDao.getLastInsertId();
        productTypeDto.setProductTypeId(getLastId);
        return productTypeDto;
    }
}
