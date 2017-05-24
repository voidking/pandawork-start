package com.voidking.pandawork.mapper;

import com.voidking.pandawork.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by voidking on 2017/5/8.
 */
public interface AdminMapper {
    public void newAdmin(Admin admin);

    public void delAdmin(@Param("adminId") int adminId);

    public void updateAdmin(Admin admin);

    public Admin queryByAdminId(@Param("adminId") int adminId);

    public List<Admin> listAll();

    public List<Admin> listByPage(@Param("pageCurrent") int pageCurrent, @Param("pageSize") int pageSize);

    public int countAdmin();

    public Admin login(@Param("username") String username, @Param("password") String password);
}
