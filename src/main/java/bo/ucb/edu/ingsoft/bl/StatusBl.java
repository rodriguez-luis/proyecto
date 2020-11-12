package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.StatusDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.StatusCreate;
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

    public StatusCreate createStatus(StatusCreate statusCreate, Transaction transaction){
        statusCreate.setTxId(transaction.getTxId());
        statusCreate.setTxUserId(transaction.getTxUserId());
        statusCreate.setTxHost(transaction.getTxHost());
        statusCreate.setTxDate(transaction.getTxDate());
        statusDao.create(statusCreate);
        Integer getLastId = transactionDao.getLastInsertId();
        statusCreate.setStatusId(getLastId);
        return statusCreate;
    }
}
