package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.BrandBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.BrandDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.util.List;


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



}
