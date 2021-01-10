package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.SaleBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/v1/sale")
public class SaleApi {

    private SaleBl saleBl;
    private TransactionBl transactionBl;

    private static final Logger LOGGER = LoggerFactory.getLogger(SaleApi.class);

    @Autowired
    public SaleApi(TransactionBl transactionBl, SaleBl saleBl){
        this.transactionBl = transactionBl;
        this.saleBl = saleBl;
    }




}
