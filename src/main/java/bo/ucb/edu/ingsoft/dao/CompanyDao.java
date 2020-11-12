package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.Company;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyDao {

    public Company findByCompanyId(Integer companyId);
    public void create(Company company);
    public void delete(Company company);
    public void update(Company company);
}
