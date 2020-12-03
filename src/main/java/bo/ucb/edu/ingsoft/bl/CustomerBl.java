package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.PersonDao;
import bo.ucb.edu.ingsoft.dao.UserDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.UserDto;
import bo.ucb.edu.ingsoft.model.Person;
import bo.ucb.edu.ingsoft.model.User;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public UserDto createUser(UserDto userDto, Transaction transaction, Person person, User user) {
        person.setTxId(transaction.getTxId());
        person.setTxHost(transaction.getTxHost());
        person.setTxUserId(transaction.getTxUserId());
        person.setTxDate(transaction.getTxDate());
        person.setCityId(userDto.getCityId());
        person.setFirstName(userDto.getFirstName());
        person.setLastName(userDto.getLastName());
        person.setPhone(userDto.getPhone());
        person.setBirthday(userDto.getBirthday());
        person.setEmail(userDto.getEmail());
        personDao.create(person);
        Integer getLastPersonId = transactionDao.getLastInsertId();
        userDto.setPersonId(getLastPersonId);

        user.setTxId(transaction.getTxId());
        user.setTxHost(transaction.getTxHost());
        user.setTxUserId(transaction.getTxUserId());
        user.setTxDate(transaction.getTxDate());
        user.setPersonId(userDto.getPersonId());
        user.setCompanyId(userDto.getCompanyId());
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        userDao.create(user);

        /*person.setTxId(transaction.getTxId());
        person.setTxHost(transaction.getTxHost());
        person.setTxUserId(transaction.getTxUserId());
        person.setTxDate(transaction.getTxDate());
        person.setCityId(userDto.getCityId());
        person.setFirstName(userDto.getFirstName());
        person.setLastName(userDto.getLastName());
        person.setPhone(userDto.getPhone());
        person.setBirthday(userDto.getBirthday());
        person.setEmail(userDto.getEmail());
        person.setPersonId(userDto.getUserId());
        personDao.create(person);

        userDto.setTxId(transaction.getTxId());
        userDto.setTxUserId(transaction.getTxUserId());
        userDto.setTxHost(transaction.getTxHost());
        userDto.setTxDate(transaction.getTxDate());
        userDao.create(userDto);
        Integer getLastUserId = transactionDao.getLastInsertId();
        userDto.setUserId(getLastUserId);*/



        return userDto;
    }

    public List<UserDto> listUser(){
        List<User> users = userDao.getUser();
        List<UserDto> usersDto = new ArrayList<UserDto>();

        for(int i=0; i < users.size(); i++){
            User user = users.get(i);
            UserDto userDto = new UserDto();

            userDto.setUsername(user.getUsername());
            //userDto.setBirthday(user.);

            usersDto.add(i, userDto);
        }
        return usersDto;
    }
}
