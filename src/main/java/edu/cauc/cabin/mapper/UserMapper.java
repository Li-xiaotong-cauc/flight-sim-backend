package edu.cauc.cabin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.cauc.cabin.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {


    int save(User user);

    @Select("select * from `user` where account = #{account}")
    User selectByAccount(String account);

}
