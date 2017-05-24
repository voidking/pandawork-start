package com.voidking.pandawork.service;

import com.voidking.pandawork.entity.Admin;
import com.voidking.pandawork.entity.User;

import java.util.List;

/**
 * Created by voidking on 2017/5/8.
 */
public interface AdminService {
    public void newAdmin(Admin admin);

    public void delAdmin(int adminId);

    public void updateAdmin(Admin admin);

    public Admin queryByAdminId(int adminId);

    public List<Admin> listAll();

    public List<Admin> listByPage(int pageNum, int pageSize);

    public int countAdmin();

    public Admin login(String username, String password);

}
