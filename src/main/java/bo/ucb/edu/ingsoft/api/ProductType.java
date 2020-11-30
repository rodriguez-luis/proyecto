package bo.ucb.edu.ingsoft.api;


import bo.ucb.edu.ingsoft.bl.ProductTypeBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.ProductTypeDto;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/v1/producttype")
public class ProductType {
    private ProductTypeBl productTypeBl;
    private TransactionBl transactionBl;

    @Autowired
    public ProductType(ProductTypeBl productTypeBl, TransactionBl transactionBl) {
        this.productTypeBl = productTypeBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping( value="/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public bo.ucb.edu.ingsoft.dto.ProductTypeDto findById(@PathVariable("id") Integer id, HttpServletRequest request) {
        return productTypeBl.findByProductTypeById(id);
    }


    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)

    public ProductTypeDto productTypeCreate (@RequestBody ProductTypeDto productTypeDto,
                                             HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        ProductTypeDto productTypeDtoResponse = productTypeBl.productTypeCreate(productTypeDto,transaction);
        return productTypeDtoResponse;
    }


}
