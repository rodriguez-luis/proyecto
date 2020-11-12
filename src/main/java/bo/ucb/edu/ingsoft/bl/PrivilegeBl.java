package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.PrivilegeDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.PrivilegeCreate;
import bo.ucb.edu.ingsoft.dto.PrivilegeUpdate;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrivilegeBl {
    private PrivilegeDao privilegeDao;
    private TransactionDao transactionDao;

    @Autowired
    public PrivilegeBl(PrivilegeDao privilegeDao, TransactionDao transactionDao) {
        this.privilegeDao = privilegeDao;
        this.transactionDao = transactionDao;
    }

    public PrivilegeCreate createPrivilege(PrivilegeCreate privilegeCreate, Transaction transaction){
        privilegeCreate.setTxId(transaction.getTxId());
        privilegeCreate.setTxUserId(transaction.getTxUserId());
        privilegeCreate.setTxHost(transaction.getTxHost());
        privilegeCreate.setTxDate(transaction.getTxDate());
        privilegeDao.create(privilegeCreate);
        Integer getLastId = transactionDao.getLastInsertId();
        privilegeCreate.setPrivilegeId(getLastId);
        return privilegeCreate;
    }

    public PrivilegeUpdate updatePrivilege(PrivilegeUpdate privilegeUpdate, Transaction transaction){
        privilegeUpdate.setTxId(transaction.getTxId());
        privilegeUpdate.setTxUserId(transaction.getTxUserId());
        privilegeUpdate.setTxHost(transaction.getTxHost());
        privilegeUpdate.setTxDate(transaction.getTxDate());
        privilegeDao.update(privilegeUpdate);
        return privilegeUpdate;
    }
}
