package com.voidking.pandawork.mapper;

import com.voidking.pandawork.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by voidking on 2017/5/8.
 */
public interface UserMapper {
    public void newUser(User user);

    public void delUser(@Param("userId") int userId);

    public void updateUser(User user);

    public User queryByUserId(@Param("userId") int userId);

    public List<User> listAll();

    public List<User> listByPage(@Param("pageCurrent") int pageCurrent,@Param("pageSize") int pageSize);

    public int countUser();

    public User login(@Param("username") String username,@Param("password") String password);
}
