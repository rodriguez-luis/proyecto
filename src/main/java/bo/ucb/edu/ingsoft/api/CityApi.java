package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.CityBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.CityCreate;
import bo.ucb.edu.ingsoft.model.Transaction;
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
@RequestMapping(value = "/v1/city")
public class CityApi {
    private CityBl cityBl;
    private TransactionBl transactionBl;
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyApi.class);

    @Autowired
    public CityApi(CityBl cityBl, TransactionBl transactionBl) {
        this.cityBl = cityBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public CityCreate createCity(@RequestBody CityCreate cityCreate, HttpServletRequest request){
        //Creamos transaccion para la operacion.
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        CityCreate cityCreateResponse = cityBl.createCity(cityCreate, transaction);
        return cityCreateResponse;
    }


}
