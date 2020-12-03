package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.UserDto;
import bo.ucb.edu.ingsoft.model.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserDao {
    public User findByUserId(Integer userId);
    public void create(User user);
    public Integer getLastInsertId();
    public List<User> getUser();
}
