package bo.ucb.edu.ingsoft.api;


import bo.ucb.edu.ingsoft.bl.CheckoutBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.CheckoutDto;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/v1/checkout")
public class CheckoutApi {
    private CheckoutBl checkoutBl;
    private TransactionBl transactionBl;

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckoutApi.class);
    @Autowired
    public CheckoutApi(CheckoutBl checkoutBl, TransactionBl transactionBl) {
        this.checkoutBl = checkoutBl;
        this.transactionBl =  transactionBl;
    }
    @RequestMapping(value = "/orders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CheckoutDto> selectCheckouts(HttpServletRequest request) {
        return checkoutBl.selectCheckouts();
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public CheckoutDto createCheckout(@RequestBody CheckoutDto checkoutDto, HttpServletRequest request) {
        // Creamos transaccion para la operación.
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        CheckoutDto checkoutResponse = checkoutBl.createCheckout(checkoutDto, transaction);
        return checkoutResponse;
    }
}
