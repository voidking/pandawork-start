package com.voidking.pandawork.mapper;

import com.voidking.pandawork.entity.User;

import java.util.List;

/**
 * Created by voidking on 2017/5/8.
 */
public interface UserMapper {
    public void newUser(User user);

    public void delUser(int userId);

    public void updateUser(User user);

    public User queryByUserId(int userId);

    public List<User> listAll();

    public List<User> listByPage(int pageNum, int pageSize);

    public int countUser();

}
