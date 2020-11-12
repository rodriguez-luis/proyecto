package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.PrivilegeBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.PrivilegeCreate;
import bo.ucb.edu.ingsoft.dto.PrivilegeUpdate;
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
@RequestMapping(value = "/v1/privilege")
public class PrivilegeApi {
    private PrivilegeBl privilegeBl;
    private TransactionBl transactionBl;
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyApi.class);

    @Autowired
    public PrivilegeApi(PrivilegeBl privilegeBl, TransactionBl transactionBl) {
        this.privilegeBl = privilegeBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public PrivilegeCreate createPrivilege(@RequestBody PrivilegeCreate privilegeCreate, HttpServletRequest request){
        //Creamos transaccion para la operacion.
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        PrivilegeCreate privilegeCreateResponse = privilegeBl.createPrivilege(privilegeCreate, transaction);
        return privilegeCreateResponse;
    }

    @RequestMapping(method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public PrivilegeUpdate updatePrivilege(@RequestBody PrivilegeUpdate privilegeUpdate, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction((transaction));
        PrivilegeUpdate privilegeUpdateResponse = privilegeBl.updatePrivilege(privilegeUpdate, transaction);
        return privilegeUpdateResponse;
    }
}
