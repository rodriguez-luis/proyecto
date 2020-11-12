package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.CityCreate;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CityDao {
    public void create(CityCreate cityCreate);
}
