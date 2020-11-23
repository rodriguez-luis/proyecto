package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.RoleDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.RoleDto;
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

    public RoleDto createRole(RoleDto roleDto, Transaction transaction){
        roleDto.setTxId(transaction.getTxId());
        roleDto.setTxUserId(transaction.getTxUserId());
        roleDto.setTxHost(transaction.getTxHost());
        roleDto.setTxDate(transaction.getTxDate());
        roleDao.create(roleDto);
        Integer getLastId = transactionDao.getLastInsertId();
        roleDto.setRoleId(getLastId);
        return roleDto;
    }
}
