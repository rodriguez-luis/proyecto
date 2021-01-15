package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.ProductoReserva;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductoReservaDao {

    public List<ProductoReserva> getPr();
    public ProductoReserva findByPrId(Integer prId);
    public void create(ProductoReserva productoReserva);
}
