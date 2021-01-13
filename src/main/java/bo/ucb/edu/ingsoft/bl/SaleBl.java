package bo.ucb.edu.ingsoft.bl;


import bo.ucb.edu.ingsoft.dao.SaleDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.CheckoutDto;
import bo.ucb.edu.ingsoft.dto.CompanyDto;
import bo.ucb.edu.ingsoft.dto.SaleDto;
import bo.ucb.edu.ingsoft.model.Checkout;
import bo.ucb.edu.ingsoft.model.Company;
import bo.ucb.edu.ingsoft.model.Sale;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Service
public class SaleBl {

    private TransactionDao transactionDao;
    private SaleDao saleDao;

    @Autowired
    public SaleBl(TransactionDao transactionDao, SaleDao saleDao){
        this.transactionDao = transactionDao;
        this.saleDao = saleDao;
    }

    public List<SaleDto> listSale(){
        List<Sale> sales = saleDao.getSale();
        List<SaleDto> salesDto = new ArrayList<SaleDto>();

        for(int i=0; i < sales.size(); i++){
            Sale sale = sales.get(i);
            SaleDto saleDto = new SaleDto();


            saleDto.setSaleId(sale.getSaleId());
            saleDto.setCompanyId(sale.getCompanyId());
            saleDto.setCard(sale.getCard());
            saleDto.setMonth(sale.getMonth());
            saleDto.setYear(sale.getYear());
            saleDto.setSecurityCode(sale.getSecurityCode());

            saleDto.setName(sale.getName());
            saleDto.setPhone(sale.getPhone());
            saleDto.setDirection(sale.getDirection());
            saleDto.setTotal(sale.getTotal());

            salesDto.add(i, saleDto);
        }
        return salesDto;
    }

    public SaleDto findSaleById(Integer saleId) {
        Sale sale = saleDao.findBySaleId(saleId);
        SaleDto saleDto = new SaleDto();

        saleDto.setSaleId(sale.getSaleId());
        saleDto.setCompanyId(sale.getCompanyId());
        saleDto.setCard(sale.getCard());
        saleDto.setMonth(sale.getMonth());
        saleDto.setYear(sale.getYear());
        saleDto.setSecurityCode(sale.getSecurityCode());

        saleDto.setName(sale.getName());
        saleDto.setPhone(sale.getPhone());
        saleDto.setDirection(sale.getDirection());
        saleDto.setTotal(sale.getTotal());
        return saleDto;
    }


    public SaleDto createSale(SaleDto saleDto, Transaction transaction) {
        Sale sale = new Sale();
        sale.setCompanyId(saleDto.getCompanyId());
        sale.setCard(saleDto.getCard());
        sale.setMonth(saleDto.getMonth());
        sale.setYear(saleDto.getYear());
        sale.setSecurityCode(saleDto.getSecurityCode());
        sale.setName(saleDto.getName());
        sale.setPhone(saleDto.getPhone());
        sale.setDirection(saleDto.getDirection());
        sale.setTotal(saleDto.getTotal());

        sale.setTxId(transaction.getTxId());
        sale.setTxUserId(transaction.getTxUserId());
        sale.setTxHost(transaction.getTxHost());
        sale.setTxDate(transaction.getTxDate());
        sale.setStatus(1);

        saleDao.create(sale);
        Integer getLastId = transactionDao.getLastInsertId();
        saleDto.setSaleId(getLastId);
        return saleDto;

    }
}
