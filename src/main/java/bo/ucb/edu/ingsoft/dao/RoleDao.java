package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.RoleCreate;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoleDao {
    public void create(RoleCreate roleCreate);
}
