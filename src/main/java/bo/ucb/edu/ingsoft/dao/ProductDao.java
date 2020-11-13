package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDao {
    public Product findByProductId(Integer productId);
    public void create(Product product);

}
