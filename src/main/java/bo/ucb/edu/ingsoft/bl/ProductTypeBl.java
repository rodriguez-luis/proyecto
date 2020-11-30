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

    public ProductTypeDto findByProductTypeById (Integer productTypeId){
        ProductType productType = productTypeDao.findProductTypeById(productTypeId);
        ProductTypeDto productTypeDto = new ProductTypeDto();
        productTypeDto.setProductTypeId(productType.getProductTypeId());
        productTypeDto.setTypeName(productType.getType_name());
        return productTypeDto;
    }


    public ProductTypeDto productTypeCreate(ProductTypeDto productTypeDto, Transaction transaction){
        ProductType productType = new ProductType();
        productType.setType_name(productTypeDto.getTypeName());
        productType.setTxId(transaction.getTxId());
        productType.setTxUserId(transaction.getTxUserId());
        productType.setTxHost(transaction.getTxHost());
        productType.setTxDate(transaction.getTxDate());

        productTypeDao.create(productType);
        Integer getLastId = transactionDao.getLastInsertId();
        productTypeDto.setProductTypeId(getLastId);
        return productTypeDto;
    }}