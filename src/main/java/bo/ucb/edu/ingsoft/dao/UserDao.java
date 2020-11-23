package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.UserDto;
import bo.ucb.edu.ingsoft.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    public User findByUserId(Integer userId);
    public void create(UserDto userDto);
    public Integer getLastInsertId();
}
