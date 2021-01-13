package bo.ucb.edu.ingsoft.dao;


import bo.ucb.edu.ingsoft.model.Company;
import bo.ucb.edu.ingsoft.model.Sale;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SaleDao {

    public List<Sale> getSale();
    public Sale findBySaleId(Integer saleId);
    public void create(Sale sale);
    public void update(Sale sale);
    public void delete(Sale sale);


}
