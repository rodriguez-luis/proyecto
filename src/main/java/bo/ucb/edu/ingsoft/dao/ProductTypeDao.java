package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.ProductTypeDto;
import bo.ucb.edu.ingsoft.model.ProductType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductTypeDao {
    public List<ProductType> getProducttype();
    public ProductType findProductTypeById(Integer productTypeId);
    public void create (ProductType productType);
    public void update(ProductType productType);
    public void save(ProductType productType);
    public void delete (ProductType productType);
    public ProductType productTypeInfo(Integer productTypeId);


}
