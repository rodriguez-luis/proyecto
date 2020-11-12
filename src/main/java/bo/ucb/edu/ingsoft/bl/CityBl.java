package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.CityDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.CityCreate;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityBl {
    private CityDao cityDao;
    private TransactionDao transactionDao;

    @Autowired
    public CityBl(CityDao cityDao, TransactionDao transactionDao) {
        this.cityDao = cityDao;
        this.transactionDao = transactionDao;
    }

    public CityCreate createCity(CityCreate cityCreate, Transaction transaction){
        cityCreate.setTxId(transaction.getTxId());
        cityCreate.setTxUserId(transaction.getTxUserId());
        cityCreate.setTxHost(transaction.getTxHost());
        cityCreate.setTxDate(transaction.getTxDate());
        cityDao.create(cityCreate);
        Integer getLastId = transactionDao.getLastInsertId();
        cityCreate.setCityId(getLastId);
        return cityCreate;
    }
}
