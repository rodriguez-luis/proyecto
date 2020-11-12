package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.PrivilegeCreate;
import bo.ucb.edu.ingsoft.dto.PrivilegeUpdate;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PrivilegeDao {
    public void create(PrivilegeCreate privilegeCreate);
    public void update(PrivilegeUpdate privilegeUpdate);
}
