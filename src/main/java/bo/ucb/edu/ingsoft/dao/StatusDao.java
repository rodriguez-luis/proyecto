package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.StatusDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StatusDao {
    public void create(StatusDto statusDto);
}
