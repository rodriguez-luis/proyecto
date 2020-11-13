package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.ProductTypeCreate;
import bo.ucb.edu.ingsoft.model.ProductType;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductTypeDao {
    public ProductType findProductTypeById(Integer productTypeId);
    public void create (ProductTypeCreate productType);

}