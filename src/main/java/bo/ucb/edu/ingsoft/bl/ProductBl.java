package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.ProductDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.model.Product;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductBl {
    private TransactionDao transactionDao;
    private ProductDao productDao;

    @Autowired
    public ProductBl(TransactionDao transactionDao, ProductDao productDao) {

        this.transactionDao = transactionDao;
        this.productDao = productDao;
    }
    public Product findProductById(Integer productId) {
        return  productDao.findByProductId(productId);
    }
    public Product createProduct(Product product, Transaction transaction) {
        product.setTxId(transaction.getTxId());
        product.setTxUserId(transaction.getTxUserId());
        product.setTxHost(transaction.getTxHost());
        product.setTxDate(transaction.getTxDate());
        productDao.create(product);
        Integer getLastId = transactionDao.getLastInsertId();
        product.setProductId(getLastId);
        return product;
    }
}
