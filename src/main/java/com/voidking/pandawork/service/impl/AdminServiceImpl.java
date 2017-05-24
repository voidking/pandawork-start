package com.voidking.pandawork.service.impl;

import com.voidking.pandawork.entity.Admin;
import com.voidking.pandawork.mapper.AdminMapper;
import com.voidking.pandawork.service.AdminService;
import com.voidking.pandawork.util.ConnectDB;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by voidking on 2017/5/12.
 */
public class AdminServiceImpl implements AdminService {
    private SqlSessionFactory sqlSessionFactory = null;
    private AdminMapper adminMapper = null;

    public AdminServiceImpl(){
        sqlSessionFactory = ConnectDB.getInstance().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        adminMapper = session.getMapper(AdminMapper.class);
    }

    public void newAdmin(Admin admin) {
        adminMapper.newAdmin(admin);
    }

    public void delAdmin(int adminId) {
        adminMapper.delAdmin(adminId);
    }

    public void updateAdmin(Admin admin) {
        adminMapper.updateAdmin(admin);
    }

    public Admin queryByAdminId(int adminId) {
        Admin admin = adminMapper.queryByAdminId(adminId);
        return admin;
    }

    public List<Admin> listAll() {
        List<Admin> adminList = adminMapper.listAll();
        return adminList;
    }

    public List<Admin> listByPage(int pageNum, int pageSize) {
        List<Admin> adminList = adminMapper.listByPage((pageNum-1)*pageSize,pageSize);
        return adminList;
    }

    public int countAdmin() {
        int result = adminMapper.countAdmin();
        return result;
    }

    public Admin login(String username, String password) {
        Admin admin = adminMapper.login(username, password);
        return admin;
    }
}
