package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.CheckoutDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.CheckoutDto;
import bo.ucb.edu.ingsoft.dto.CompanyDto;
import bo.ucb.edu.ingsoft.model.Checkout;
import bo.ucb.edu.ingsoft.model.Company;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CheckoutBl {
    private TransactionDao transactionDao;
    private CheckoutDao checkoutDao;
    @Autowired
    public CheckoutBl(TransactionDao transactionDao, CheckoutDao checkoutDao) {
        this.transactionDao = transactionDao;
        this.checkoutDao = checkoutDao;
    }
    public List<CheckoutDto> selectCheckouts(){
        List<Checkout> checkouts= checkoutDao.getOrders();
        List<CheckoutDto> checkoutDtos = new ArrayList<CheckoutDto>();
        for (int i=0; i< checkouts.size(); i++){
            Checkout checkout= checkouts.get(i);
            CheckoutDto checkoutDto = new CheckoutDto();

            checkoutDto.setCheckoutId (checkout.getCheckoutId());
            checkoutDto.setCartId (checkout.getCartId() );
            checkoutDto.setPaymentDetailsId (checkout.getPaymentDetailsId() );
            checkoutDto.setDate(checkout.getDate());
            checkoutDto.setTotal(checkout.getTotal());
            checkoutDto.setContact(checkout.getContact());
            checkoutDto.setAddress(checkout.getAddress());
            checkoutDtos.add(i,checkoutDto);
        }
        return checkoutDtos;
    }

    public CheckoutDto findCheckoutById(Integer checkoutId) {
        Checkout checkout = checkoutDao.findByCheckoutId(checkoutId);
        CheckoutDto checkoutDto = new CheckoutDto();
        checkoutDto.setCheckoutId(checkout.getCheckoutId());
        checkoutDto.setCartId(checkout.getCartId());
        checkoutDto.setPaymentDetailsId(checkout.getPaymentDetailsId());

        checkoutDto.setDate(checkout.getDate());
        checkoutDto.setTotal(checkout.getTotal());
        checkoutDto.setContact(checkout.getContact());
        checkoutDto.setAddress(checkout.getAddress());
        return checkoutDto;
    }


    public CheckoutDto createCheckout(CheckoutDto checkoutDto, Transaction transaction) {
        Checkout checkout = new Checkout();
        checkout.setCheckoutId(checkoutDto.getCheckoutId());
        checkout.setCartId(checkoutDto.getCartId());
        checkout.setPaymentDetailsId(checkoutDto.getPaymentDetailsId());
        checkout.setDate(checkoutDto.getDate());
        checkout.setTotal(checkoutDto.getTotal());

        checkout.setTxId(transaction.getTxId());
        checkout.setTxHost(transaction.getTxHost());
        checkout.setTxUserId(transaction.getTxUserId());
        checkout.setTxDate(transaction.getTxDate());

        checkout.setContact(checkoutDto.getContact());
        checkout.setAddress(checkoutDto.getAddress());
        checkout.setStatus(1);
        checkoutDao.create(checkout);
        Integer getLastId = transactionDao.getLastInsertId();
        checkoutDto.setCheckoutId(getLastId);
       //checkoutDto.setDate(transaction.getTxDate());
        return checkoutDto;
    }

    public void delete(Integer idCheckout, Transaction transaction){
        Checkout checkout = new Checkout();
        checkout.setCheckoutId(idCheckout);
        checkout.setTxId(transaction.getTxId());
        checkout.setTxUserId(transaction.getTxUserId());
        checkout.setTxHost(transaction.getTxHost());
        checkout.setTxDate(transaction.getTxDate());
        checkout.setStatus(0);
        checkoutDao.delete(checkout);
    }

}
