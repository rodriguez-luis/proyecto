package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.CompanyDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.CompanyDto;
import bo.ucb.edu.ingsoft.dto.PrivilegeDto;
import bo.ucb.edu.ingsoft.model.Company;
import bo.ucb.edu.ingsoft.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyBl {

    private TransactionDao transactionDao;
    private CompanyDao companyDao;

    @Autowired
    public CompanyBl(TransactionDao transactionDao, CompanyDao companyDao) {

        this.transactionDao = transactionDao;
        this.companyDao = companyDao;
    }

    public List<CompanyDto> listCompany(){
        List<Company> companies = companyDao.getCompany();
        List<CompanyDto> companiesDto = new ArrayList<CompanyDto>();

        for(int i=0; i < companies.size(); i++){
            Company company = companies.get(i);
            CompanyDto companyDto = new CompanyDto();

            companyDto.setCompanyId(company.getCompanyId());
            companyDto.setName(company.getName());
            companyDto.setDirection(company.getDirection());
            companyDto.setPhone(company.getPhone());
            companyDto.setEmail(company.getEmail());

            companiesDto.add(i, companyDto);
        }
        return companiesDto;
    }

    public CompanyDto findCompanyById(Integer companyId) {
        Company company =  companyDao.findByCompanyId(companyId);
        CompanyDto companyDto = new CompanyDto();
        companyDto.setCompanyId(company.getCompanyId());
        companyDto.setName(company.getName());
        companyDto.setDirection(company.getDirection());
        companyDto.setPhone(company.getPhone());
        companyDto.setEmail(company.getEmail());
        return companyDto;
    }

    public CompanyDto createCompany(CompanyDto companyDto, Transaction transaction) {
        Company company = new Company();
        company.setName(companyDto.getName());
        company.setDirection(companyDto.getDirection());
        company.setPhone(companyDto.getPhone());
        company.setEmail(companyDto.getEmail());
        company.setTxId(transaction.getTxId());
        company.setTxUserId(transaction.getTxUserId());
        company.setTxHost(transaction.getTxHost());
        company.setTxDate(transaction.getTxDate());
        company.setStatus(1);
        companyDao.create(company);
        Integer getLastId = transactionDao.getLastInsertId();
        companyDto.setCompanyId(getLastId);
        return companyDto;
    }


    public void delete(Integer idCompany, Transaction transaction)
    {
        Company company= new Company();
        company.setCompanyId(idCompany);
        company.setTxId(transaction.getTxId());
        company.setTxUserId(transaction.getTxUserId());
        company.setTxHost(transaction.getTxHost());
        company.setTxDate(transaction.getTxDate());
        company.setStatus(0);
        companyDao.delete(company);
    }

    public CompanyDto updateCompany(CompanyDto companyDto, Transaction transaction){
        Company company = new Company();
        company.setCompanyId(companyDto.getCompanyId());
        company.setName(companyDto.getName());
        company.setDirection(companyDto.getDirection());
        company.setPhone(companyDto.getPhone());
        company.setEmail(companyDto.getEmail());
        company.setTxId(transaction.getTxId());
        company.setTxUserId(transaction.getTxUserId());
        company.setTxHost(transaction.getTxHost());
        company.setTxDate(transaction.getTxDate());
        company.setStatus(1);
        companyDao.update(company);
        return companyDto;
    }
}
