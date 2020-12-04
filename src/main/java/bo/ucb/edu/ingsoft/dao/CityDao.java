package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.CityDto;
import bo.ucb.edu.ingsoft.model.City;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CityDao {
    public void create(City city);
    public City findByCityId(Integer cityId);
    public List<City> getCity();
    public void update(City city);
}
