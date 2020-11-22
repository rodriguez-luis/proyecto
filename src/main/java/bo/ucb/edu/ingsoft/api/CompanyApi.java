package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.CompanyBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.PrivilegeUpdate;
import bo.ucb.edu.ingsoft.model.Company;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping(value = "/v1/company")
public class CompanyApi {

    private CompanyBl companyBl;
    private TransactionBl transactionBl;

    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyApi.class);

    @Autowired
    public CompanyApi(CompanyBl companyBl, TransactionBl transactionBl) {
        this.companyBl = companyBl;
        this.transactionBl =  transactionBl;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Company findById(@PathVariable("id") Integer id, HttpServletRequest request) {
        return companyBl.findCompanyById(id);
    }


    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Company createCompany(@RequestBody Company company, HttpServletRequest request) {
        // Creamos transaccion para la operación.
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        Company companyResponse = companyBl.createCompany(company, transaction);
        return companyResponse;
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer idCompany, HttpServletRequest request ){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transaction=transactionBl.createTransaction(transaction);
        companyBl.delete(idCompany, transaction);
    }

    @RequestMapping(method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Company updateCompany(@RequestBody Company company, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction((transaction));
        Company companyResponse = companyBl.updateCompany(company, transaction);
        return companyResponse;
    }



}
