package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.BrandDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.BrandDto;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.model.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandBl {
    private BrandDao brandDao;
    private TransactionDao transactionDao;

    @Autowired
    public BrandBl(BrandDao brandDao, TransactionDao transactionDao){
        this.brandDao = brandDao;
        this.transactionDao = transactionDao;
    }

    public BrandDto createBrand(BrandDto brandDto, Transaction transaction){
        Brand brand=new Brand();
        brand.setName(brandDto.getName());
        brand.setTxId(transaction.getTxId());
        brand.setTxUserId(transaction.getTxUserId());
        brand.setTxHost(transaction.getTxHost());
        brand.setStatus(1);
        brandDao.create(brand);
        Integer getLastId = transactionDao.getLastInsertId();
        brandDto.setBrandId(getLastId);
        return brandDto;
    }



}
