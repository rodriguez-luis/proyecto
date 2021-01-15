package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.*;
import bo.ucb.edu.ingsoft.dto.ProductoReservaDto;
import bo.ucb.edu.ingsoft.dto.UserDto;
import bo.ucb.edu.ingsoft.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoReservaBl {

    private ProductoReservaDao productoReservaDao;
    private ProductDao productDao;
    private CheckoutDao checkoutDao;
    private TransactionDao transactionDao;

    @Autowired
    public ProductoReservaBl(ProductoReservaDao productoReservaDao, ProductDao productDao, CheckoutDao checkoutDao, TransactionDao transactionDao) {
        this.productoReservaDao = productoReservaDao;
        this.productDao = productDao;
        this.checkoutDao = checkoutDao;
        this.transactionDao = transactionDao;
    }

    public ProductoReservaDto createPr(ProductoReservaDto prDto, Transaction transaction) {
        //Datos ProductoReserva
        ProductoReserva pr = new ProductoReserva();

        pr.setProductId(prDto.getProductId());
        pr.setCheckoutId(prDto.getCheckoutId());
        pr.setCantidad(prDto.getCantidad());

        pr.setTxId(transaction.getTxId());
        pr.setTxHost(transaction.getTxHost());
        pr.setTxUserId(transaction.getTxUserId());
        pr.setTxDate(transaction.getTxDate());
        pr.setStatus(1);

        productoReservaDao.create(pr);
        Integer getLastId = transactionDao.getLastInsertId();
        prDto.setPrId(getLastId);

        //Datos Product
        /***/
        Product product = new Product();
        product.setTxId(transaction.getTxId());
        product.setTxHost(transaction.getTxHost());
        product.setTxUserId(transaction.getTxUserId());
        product.setTxDate(transaction.getTxDate());
        product.setStatus(1);

        product.setProductId(prDto.getProductId());
        product.setCompanyId(prDto.getCompanyId());
        product.setProductTypeId(prDto.getProductTypeId());
        product.setCityId(prDto.getCityId());
        product.setBrandId(prDto.getBrandId());

        product.setProductName(prDto.getProductName());
        product.setModel(prDto.getModel());
        product.setProductDescription(prDto.getProductDescription());
        product.setStock(prDto.getStock());
        product.setWeight(prDto.getWeight());
        product.setUnitPrice(prDto.getUnitPrice());
        product.setCurrency(prDto.getCurrency());
        product.setImg(prDto.getImg());
        productDao.create(product);

        //Datos Checkout
        /***/
        Checkout checkout = new Checkout();
        checkout.setTxId(transaction.getTxId());
        checkout.setTxHost(transaction.getTxHost());
        checkout.setTxUserId(transaction.getTxUserId());
        checkout.setTxDate(transaction.getTxDate());
        checkout.setStatus(1);

        checkout.setCheckoutId(prDto.getCheckoutId());
        checkout.setCartId(prDto.getCartId());
        checkout.setPaymentDetailsId(prDto.getPaymentDetailsId());

        checkout.setDate(prDto.getDate());
        checkout.setTotal(prDto.getTotal());
        checkout.setContact(prDto.getContact());
        checkout.setAddress(prDto.getAddress());
        checkoutDao.create(checkout);

        return prDto;
    }
}
