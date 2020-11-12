package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.UserDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.model.User;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerBl {
    private UserDao userDao;
    private TransactionDao transactionDao;
    @Autowired
    public CustomerBl(UserDao userDao, TransactionDao transactionDao) {
        this.userDao = userDao;
        this.transactionDao = transactionDao;
    }

    public User findUserById(Integer userId) {
        return  userDao.findByUserId(userId);
    }

    public User createUser(User user, Transaction transaction) {
        user.setTxId(transaction.getTxId());
        user.setTxUserId(transaction.getTxUserId());
        user.setTxHost(transaction.getTxHost());
        user.setTxDate(transaction.getTxDate());

        userDao.create(user);
        Integer getLastId = transactionDao.getLastInsertId();
        user.setUserId(getLastId);
        return user;
    }
}
