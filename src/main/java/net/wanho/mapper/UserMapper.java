package net.wanho.mapper;

import net.wanho.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2019/6/5.
 */
public interface UserMapper {

    List<User> getAllUser();

    void addUser(User user);

    User selectuserById(Integer id);

    List<User> Selectlike(String username);

    void  adduserReturn(User user);

    void  adduserReturn2(User user);
    void  updateUserById(String username ,String gender,Integer id);
    void  updateUserById2(@Param("username") String username , @Param("gender")String gender, @Param("id")Integer id);
}
