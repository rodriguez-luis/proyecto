package bo.ucb.edu.ingsoft.dao;


import bo.ucb.edu.ingsoft.model.Sale;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SaleDao {

    public List<Sale> getSale();
    public void create(Sale sale);
}
