package com.voidking.pandawork.controller.admin;

import com.voidking.pandawork.entity.Admin;
import com.voidking.pandawork.json.JSONObject;
import com.voidking.pandawork.service.AdminService;
import com.voidking.pandawork.service.impl.AdminServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Created by voidking on 2017/5/13.
 */
@Controller
public class AdminController {

    @RequestMapping(value="/admin/login",method = RequestMethod.GET)
    public String toLogin(ModelMap modelMap){
        return "admin/login";
    }

    @RequestMapping(value="/admin/login",method = RequestMethod.POST)
    public void login(@RequestParam(value = "username") String username,
                      @RequestParam(value="password") String password,
                      HttpServletRequest request,
                      HttpServletResponse response) throws Exception{
        JSONObject jsonObj = null;

        AdminService adminService = new AdminServiceImpl();
        Admin admin = adminService.login(username, password);
        if(admin != null){
            HttpSession session = request.getSession();
            session.setAttribute("admin", admin);
            if (session.isNew()) {
                //response.getWriter().print("session创建成功，session的id是："+sessionId);
            }else {
                //response.getWriter().print("服务器已经存在该session了，session的id是："+sessionId);
            }

            jsonObj = new JSONObject("{'code':'0','ext':'登录成功'}");
        }else{
            jsonObj = new JSONObject("{'code':'1','ext':'用户名或密码错误'}");
        }

        response.setCharacterEncoding("utf8");
        PrintWriter pw = response.getWriter();
        pw.println(jsonObj);
    }

    @RequestMapping(value = "/admin/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception{
        JSONObject jsonObj = null;

        HttpSession session = request.getSession();
        session.setAttribute("admin", null);

        jsonObj = new JSONObject("{'code':'0','ext':'退出成功'}");

        response.setCharacterEncoding("utf8");
        PrintWriter pw = response.getWriter();
        pw.println(jsonObj);
    }

}
