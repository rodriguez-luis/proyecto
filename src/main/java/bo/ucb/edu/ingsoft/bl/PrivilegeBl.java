package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.PrivilegeDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.PrivilegeDto;
import bo.ucb.edu.ingsoft.dto.PrivilegeDto;
import bo.ucb.edu.ingsoft.model.Privilege;
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

    public PrivilegeDto createPrivilege(PrivilegeDto privilegeDto, Transaction transaction){
        Privilege privilege = new Privilege();
        privilege.setPrivilegeName(privilegeDto.getPrivilegeName());
        privilege.setTxId(transaction.getTxId());
        privilege.setTxUserId(transaction.getTxUserId());
        privilege.setTxHost(transaction.getTxHost());
        privilege.setTxDate(transaction.getTxDate());
        privilege.setStatus(1);
        privilegeDao.create(privilege);
        Integer getLastId = transactionDao.getLastInsertId();
        privilegeDto.setPrivilegeId(getLastId);
        return privilegeDto;
    }

    public PrivilegeDto updatePrivilege(PrivilegeDto privilegeDto, Transaction transaction){
        Privilege privilege = new Privilege();
        privilege.setPrivilegeId(privilegeDto.getPrivilegeId());
        privilege.setPrivilegeName(privilegeDto.getPrivilegeName());
        privilege.setTxId(transaction.getTxId());
        privilege.setTxUserId(transaction.getTxUserId());
        privilege.setTxHost(transaction.getTxHost());
        privilege.setTxDate(transaction.getTxDate());
        privilege.setStatus(1);
        privilegeDao.update(privilege);
        return privilegeDto;
    }
}
