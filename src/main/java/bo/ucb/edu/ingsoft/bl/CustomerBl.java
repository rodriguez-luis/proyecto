package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.PersonDao;
import bo.ucb.edu.ingsoft.dao.UserDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.UserCreate;
import bo.ucb.edu.ingsoft.model.Person;
import bo.ucb.edu.ingsoft.model.User;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerBl {
    private UserDao userDao;
    private PersonDao personDao;
    private TransactionDao transactionDao;

    @Autowired
    public CustomerBl(UserDao userDao, PersonDao personDao, TransactionDao transactionDao) {
        this.userDao = userDao;
        this.personDao = personDao;
        this.transactionDao = transactionDao;
    }

    public User findUserById(Integer userId) {
        return  userDao.findByUserId(userId);
    }

    public UserCreate createUser(UserCreate userCreate, Transaction transaction, Person person) {
        userCreate.setTxId(transaction.getTxId());
        userCreate.setTxUserId(transaction.getTxUserId());
        userCreate.setTxHost(transaction.getTxHost());
        userCreate.setTxDate(transaction.getTxDate());
        userDao.create(userCreate);
        Integer getLastId = transactionDao.getLastInsertId();
        userCreate.setUserId(getLastId);

        person.setTxId(transaction.getTxId());
        person.setTxHost(transaction.getTxHost());
        person.setTxUserId(transaction.getTxUserId());
        person.setTxDate(transaction.getTxDate());
        person.setCityId(userCreate.getCityId());
        person.setFirstName(userCreate.getFirstName());
        person.setLastName(userCreate.getLastName());
        person.setPhone(userCreate.getPhone());
        person.setBirthday(userCreate.getBirthday());
        person.setEmail(userCreate.getEmail());
        person.setPersonId(userCreate.getUserId());
        personDao.create(person);

        return userCreate;
    }
}
