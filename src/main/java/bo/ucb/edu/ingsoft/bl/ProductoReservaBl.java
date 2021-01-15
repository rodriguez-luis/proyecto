package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.*;
import bo.ucb.edu.ingsoft.dto.CompanyDto;
import bo.ucb.edu.ingsoft.dto.ProductDto;
import bo.ucb.edu.ingsoft.dto.ProductoReservaDto;
import bo.ucb.edu.ingsoft.dto.UserDto;
import bo.ucb.edu.ingsoft.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    //lista de productosReserva
    public List<ProductoReservaDto> listPr(){
        List<Product> products= productDao.getProducts();// datos productos, accedemos al metodo  productDao.getProducts()

        List<ProductoReserva> prs = productoReservaDao.getPr();
        List<ProductoReservaDto> prsDto = new ArrayList<ProductoReservaDto>();

        for(int i=0; i < prs.size(); i++){
            for(int j=0; j < products.size(); j++) {  //datos productos
                Product producto = products.get(j);//datos productos

                ProductoReserva productoReserva = prs.get(i);
                ProductoReservaDto productoReservaDto = new ProductoReservaDto();

                //datos de productoReserva
                productoReservaDto.setPrId(productoReserva.getPrId());
                productoReservaDto.setProductId(productoReserva.getProductId());
                productoReservaDto.setCheckoutId(productoReserva.getCheckoutId());
                productoReservaDto.setCantidad(productoReserva.getCantidad());

                //datos de producto
                productoReservaDto.setProductName(producto.getProductName());
                productoReservaDto.setUnitPrice(producto.getUnitPrice());

                prsDto.add(i, productoReservaDto);
            }
        }
        return prsDto;
    }


    //lista de productos prueba
    public List<ProductDto> selectProducts(){
        List<Product> products= productDao.getProducts();// datos productos
        List<ProductDto> productsDto = new ArrayList<ProductDto>();

        for (int i=0; i< products.size(); i++){
            Product product= products.get(i);
            ProductDto productDto = new ProductDto();

            productDto.setProductId(product.getProductId());
            productDto.setProductName(product.getProductName());
            productDto.setModel(product.getModel());
            productDto.setProductDescription(product.getProductDescription());
            productDto.setStock(product.getStock());
            productDto.setWeight(product.getWeight());
            productDto.setCompanyId(product.getCompanyId());
            productDto.setProductTypeId(product.getProductTypeId());
            productDto.setCityId(product.getCityId());
            productDto.setUnitPrice(product.getUnitPrice());
            productDto.setCurrency(product.getCurrency());
            productDto.setBrandId(product.getBrandId());
            productDto.setImg(product.getImg());
            productsDto.add(i,productDto);
        }
        return productsDto;
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
