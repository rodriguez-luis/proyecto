package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.StatusDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.StatusDto;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusBl {
    private StatusDao statusDao;
    private TransactionDao transactionDao;

    @Autowired
    public StatusBl(StatusDao statusDao, TransactionDao transactionDao) {
        this.statusDao = statusDao;
        this.transactionDao = transactionDao;
    }

    public StatusDto createStatus(StatusDto statusDto, Transaction transaction){
        statusDto.setTxId(transaction.getTxId());
        statusDto.setTxUserId(transaction.getTxUserId());
        statusDto.setTxHost(transaction.getTxHost());
        statusDto.setTxDate(transaction.getTxDate());
        statusDao.create(statusDto);
        Integer getLastId = transactionDao.getLastInsertId();
        statusDto.setStatusId(getLastId);
        return statusDto;
    }
}
