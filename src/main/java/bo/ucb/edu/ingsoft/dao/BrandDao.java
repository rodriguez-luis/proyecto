package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.Brand;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BrandDao {
    public void create (Brand brand);
    public Brand findByBrandId (Integer brandId);
    public List<Brand> getBrand();
    public void update(Brand brand);
}
