package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.Checkout;
import bo.ucb.edu.ingsoft.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CheckoutDao {
    public void create(Checkout checkout);
    public List<Checkout> getOrders();
}
