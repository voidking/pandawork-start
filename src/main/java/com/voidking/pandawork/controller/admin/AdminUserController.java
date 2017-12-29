package com.voidking.pandawork.controller.admin;

import com.voidking.pandawork.entity.Admin;
import com.voidking.pandawork.entity.User;
import com.voidking.pandawork.json.JSONObject;
import com.voidking.pandawork.service.UserService;
import com.voidking.pandawork.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by voidking on 2017/12/29.
 */
@Controller
public class AdminUserController {
    @RequestMapping(value="/admin/user/list", method = RequestMethod.GET)
    public String toManage(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws Exception{
        HttpSession session = request.getSession();
        Admin admin = (Admin)session.getAttribute("admin");
        if(admin == null){
            //System.out.println("重定向");
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return null;
        }

        modelMap.put("admin",admin);
        UserService userService = new UserServiceImpl();
        List<User> userList = userService.listAll();
        modelMap.put("userList",userList);
        return "admin/user/list";
    }

    @RequestMapping(value = "/admin/user/search", method = RequestMethod.POST)
    public void getUserList(@RequestParam(value = "key") String key,
                            HttpServletRequest request, HttpServletResponse response) throws Exception{
        JSONObject jsonObj = null;
        UserService userService = new UserServiceImpl();
        List<User> userList = userService.listByKey(key);

        jsonObj = new JSONObject("{'code':'0','ext':'success'}");
        jsonObj.put("userList", userList);

        response.setCharacterEncoding("utf8");
        PrintWriter pw = response.getWriter();
        pw.println(jsonObj);
    }

    @RequestMapping(value = "/admin/user/del",method = RequestMethod.POST)
    public void delUser(@RequestParam(value = "userId") int userId,
                        HttpServletRequest request, HttpServletResponse response) throws Exception{
        JSONObject jsonObj = null;
        UserService userService = new UserServiceImpl();
        userService.delUser(userId);
        jsonObj = new JSONObject("{'code':'0','ext':'success'}");

        response.setCharacterEncoding("utf8");
        PrintWriter pw = response.getWriter();
        pw.println(jsonObj);
    }
}
