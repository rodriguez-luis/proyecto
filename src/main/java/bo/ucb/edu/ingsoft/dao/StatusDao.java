package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.StatusCreate;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StatusDao {
    public void create(StatusCreate statusCreate);
}
