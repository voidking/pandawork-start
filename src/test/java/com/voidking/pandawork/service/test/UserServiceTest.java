package com.voidking.pandawork.service.test;

import com.voidking.pandawork.entity.User;
import com.voidking.pandawork.service.UserService;
import com.voidking.pandawork.service.impl.UserServiceImpl;
import junit.framework.TestCase;

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
        User user = new User(1,"voidking","voidking");
        userService.newUser(user);
    }

    public void testDelUser() throws Exception {

    }

    public void testUpdateUser() throws Exception {

    }

    public void testQueryByUserId() throws Exception {

    }

    public void testListAll() throws Exception {

    }

    public void testListByPage() throws Exception {

    }

    public void testCountUser() throws Exception {

    }

}