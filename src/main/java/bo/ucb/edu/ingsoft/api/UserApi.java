package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.CustomerBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.User;
import bo.ucb.edu.ingsoft.dto.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/v1/user")
public class UserApi {

    private CustomerBl customerBl;
    private TransactionBl transactionBl;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserApi.class);

    @Autowired
    public UserApi(CustomerBl customerBl, TransactionBl transactionBl) {
        this.customerBl = customerBl;
        this.transactionBl =  transactionBl;
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User findById(HttpServletRequest request) {
        return customerBl.findUserById(0);
    }


    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody User user, HttpServletRequest request) {
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        User userResponse = customerBl.createUser(user, transaction);
        return userResponse;
    }
}
