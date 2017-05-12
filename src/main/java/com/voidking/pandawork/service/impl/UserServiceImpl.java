package com.voidking.pandawork.service.impl;

import com.voidking.pandawork.entity.User;
import com.voidking.pandawork.mapper.UserMapper;
import com.voidking.pandawork.service.UserService;
import com.voidking.pandawork.util.ConnectDB;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by voidking on 2017/5/12.
 */
public class UserServiceImpl implements UserService {
    private SqlSessionFactory sqlSessionFactory = null;
    private UserMapper userMapper = null;

    public UserServiceImpl(){
        sqlSessionFactory = ConnectDB.getInstance().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        userMapper = session.getMapper(UserMapper.class);
    }

    public void newUser(User user) {
        userMapper.newUser(user);
    }

    public void delUser(int userId) {
        userMapper.delUser(1);
    }

    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    public User queryByUserId(int userId) {
        User user = userMapper.queryByUserId(userId);
        return user;
    }

    public List<User> listAll() {
        List<User> userList = userMapper.listAll();
        return userList;
    }

    public List<User> listByPage(int pageNum, int pageSize) {
        List<User> userList = userMapper.listByPage(pageNum,pageSize);
        return userList;
    }

    public int countUser() {
        int result = userMapper.countUser();
        return result;
    }
}
