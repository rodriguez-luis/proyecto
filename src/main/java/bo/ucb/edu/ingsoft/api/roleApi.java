package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.RoleBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.RoleCreate;
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
@RequestMapping(value = "/v1/role")
public class roleApi {
    private RoleBl roleBl;
    private TransactionBl transactionBl;

    @Autowired
    public roleApi(RoleBl roleBl, TransactionBl transactionBl) {
        this.roleBl = roleBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public RoleCreate createRole(@RequestBody RoleCreate roleCreate, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        RoleCreate roleCreateResponse = roleBl.createRole(roleCreate, transaction);
        return roleCreateResponse;
    }
}
