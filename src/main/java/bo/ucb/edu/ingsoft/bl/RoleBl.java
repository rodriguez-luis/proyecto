package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.RoleDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.RoleCreate;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleBl {
    private RoleDao roleDao;
    private TransactionDao transactionDao;

    @Autowired
    public RoleBl(RoleDao roleDao, TransactionDao transactionDao) {
        this.roleDao = roleDao;
        this.transactionDao = transactionDao;
    }

    public RoleCreate createRole(RoleCreate roleCreate, Transaction transaction){
        roleCreate.setTxId(transaction.getTxId());
        roleCreate.setTxUserId(transaction.getTxUserId());
        roleCreate.setTxHost(transaction.getTxHost());
        roleCreate.setTxDate(transaction.getTxDate());
        roleDao.create(roleCreate);
        Integer getLastId = transactionDao.getLastInsertId();
        roleCreate.setRoleId(getLastId);
        return roleCreate;
    }
}
