package bo.ucb.edu.ingsoft.bl;


import bo.ucb.edu.ingsoft.dao.SaleDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.CompanyDto;
import bo.ucb.edu.ingsoft.dto.SaleDto;
import bo.ucb.edu.ingsoft.model.Sale;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleBl {

    private TransactionDao transactionDao;
    private SaleDao saleDao;

    @Autowired
    public SaleBl(TransactionDao transactionDao, SaleDao saleDao){
        this.transactionDao = transactionDao;
        this.saleDao = saleDao;
    }

    public SaleDto createSale(SaleDto saleDto, Transaction transaction) {
        Sale sale = new Sale();
        sale.setCompanyId(saleDto.getCompanyId());
        sale.setCard(saleDto.getCard());
        sale.setExpirationDate(saleDto.getExpirationDate());
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
