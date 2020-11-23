package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.PrivilegeDto;
import bo.ucb.edu.ingsoft.dto.PrivilegeDto;
import bo.ucb.edu.ingsoft.model.Privilege;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PrivilegeDao {
    public void create(Privilege privilege);
    public void update(Privilege Privilege);
}
