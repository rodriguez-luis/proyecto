package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.PrivilegeCreate;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PrivilegeDao {
    public void create(PrivilegeCreate privilegeCreate);
}
