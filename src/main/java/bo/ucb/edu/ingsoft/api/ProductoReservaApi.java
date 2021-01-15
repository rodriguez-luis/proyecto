package bo.ucb.edu.ingsoft.api;


import bo.ucb.edu.ingsoft.bl.CustomerBl;
import bo.ucb.edu.ingsoft.bl.ProductoReservaBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.ProductoReservaDto;
import bo.ucb.edu.ingsoft.model.*;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/v1/pr")
public class ProductoReservaApi {

    private ProductoReservaBl productoReservaBl;
    private TransactionBl transactionBl;

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductoReservaApi.class);

    @Autowired
    public ProductoReservaApi(ProductoReservaBl productoReservaBl, TransactionBl transactionBl) {
        this.productoReservaBl = productoReservaBl;
        this.transactionBl =  transactionBl;
    }


/***/
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ProductoReservaDto createPr(@RequestBody ProductoReservaDto prDto, HttpServletRequest request) {
        // Creamos transaccion para la operación.
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        ProductoReservaDto response = productoReservaBl.createPr(prDto, transaction);
        return  response;
    }

}
