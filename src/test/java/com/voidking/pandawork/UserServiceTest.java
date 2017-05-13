package com.voidking.pandawork;

import com.voidking.pandawork.entity.User;
import com.voidking.pandawork.service.UserService;
import com.voidking.pandawork.service.impl.UserServiceImpl;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created by voidking on 2017/5/12.
 */
public class UserServiceTest extends TestCase {
    private UserService userService = null;

    public void setUp() throws Exception {
        super.setUp();
        userService = new UserServiceImpl();
    }


    public void testNewUser() throws Exception {
        User user = new User();
        user.setUsername("voidking");
        user.setPassword("voidking");
        userService.newUser(user);
    }

    public void testDelUser() throws Exception {
        userService.delUser(2);
    }

    public void testUpdateUser() throws Exception {
        User user = userService.queryByUserId(1);
        user.setPassword("voidking-new");
        userService.updateUser(user);

    }

    public void testQueryByUserId() throws Exception {
        User user = userService.queryByUserId(1);
        System.out.println(user.getId());
    }

    public void testListAll() throws Exception {
        List<User> userList = userService.listAll();
        System.out.println(userList.size());
    }

    public void testListByPage() throws Exception {
        List<User> userList = userService.listByPage(2, 3);
        for(User user: userList){
            System.out.print(user.getId()+"\t");
        }
    }

    public void testCountUser() throws Exception {
        int count = userService.countUser();
        System.out.println(count);
    }

}