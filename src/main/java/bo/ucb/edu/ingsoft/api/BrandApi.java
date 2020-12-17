package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.BrandBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.BrandDto;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/v1/brand")
public class BrandApi {
    private BrandBl brandBl;
    private TransactionBl transactionBl;
    private static final Logger LOGGER = LoggerFactory.getLogger(BrandApi.class);


    @Autowired
    public BrandApi(BrandBl brandBl, TransactionBl transactionBl){
        this.brandBl = brandBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BrandDto> listBrand(HttpServletRequest request)
    {return brandBl.listBrand();}

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public BrandDto createBrand(@RequestBody BrandDto brandDto, HttpServletRequest request){
        //Creamos transaccion para la operacion.
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        BrandDto brandDtoResponse = brandBl.createBrand(brandDto, transaction);
        return brandDtoResponse;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public BrandDto findById(@PathVariable("id") Integer id, HttpServletRequest request) {
        return brandBl.findBrandById(id);
    }

    @RequestMapping(method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public BrandDto updateBrand(@RequestBody BrandDto BrandDto, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction((transaction));
        BrandDto BrandDtoResponse = brandBl.updateBrand(BrandDto, transaction);
        return BrandDtoResponse;
    }


}
