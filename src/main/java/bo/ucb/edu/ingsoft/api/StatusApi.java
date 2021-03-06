package bo.ucb.edu.ingsoft.api;

import bo.ucb.edu.ingsoft.bl.StatusBl;
import bo.ucb.edu.ingsoft.bl.TransactionBl;
import bo.ucb.edu.ingsoft.dto.StatusDto;
import bo.ucb.edu.ingsoft.model.Transaction;
import bo.ucb.edu.ingsoft.util.TransactionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/v1/status")
public class StatusApi {
    private StatusBl statusBl;
    private TransactionBl transactionBl;

    @Autowired
    public StatusApi(StatusBl statusBl, TransactionBl transactionBl) {
        this.statusBl = statusBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public StatusDto createStatus(@RequestBody StatusDto statusDto, HttpServletRequest request){
        Transaction transaction = TransactionUtil.createTransaction(request);
        transactionBl.createTransaction(transaction);
        StatusDto statusDtoResponse = statusBl.createStatus(statusDto, transaction);
        return statusDtoResponse;
    }
}
