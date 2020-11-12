package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.CompanyDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.model.Company;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyBl {

    private TransactionDao transactionDao;
    private CompanyDao companyDao;

    @Autowired
    public CompanyBl(TransactionDao transactionDao, CompanyDao companyDao) {

        this.transactionDao = transactionDao;
        this.companyDao = companyDao;
    }

    public Company findCompanyById(Integer companyId) {
        return  companyDao.findByCompanyId(companyId);
    }

    public Company createCompany(Company company, Transaction transaction) {
        company.setTxId(transaction.getTxId());
        company.setTxUserId(transaction.getTxUserId());
        company.setTxHost(transaction.getTxHost());
        company.setTxDate(transaction.getTxDate());
        companyDao.create(company);
        Integer getLastId = transactionDao.getLastInsertId();
        company.setCompanyId(getLastId);
        return company;
    }

    public void delete(Integer idCompany, Transaction transaction)
    {
        Company company= new Company();
        company.setCompanyId(idCompany);
        company.setTxId(transaction.getTxId());
        company.setTxUserId(transaction.getTxUserId());
        company.setTxHost(transaction.getTxHost());
        company.setTxDate(transaction.getTxDate());

        companyDao.delete(company);

    }

}
