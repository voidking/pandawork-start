package com.voidking.pandawork.controller.admin;

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

/**
 * Created by voidking on 2017/5/13.
 */
@Controller
public class AdminController {

    @RequestMapping(value = "/admin/reg", method = RequestMethod.GET)
    public String toReg(ModelMap modelMap){
        return "reg";
    }

    @RequestMapping(value = "/admin/reg", method = RequestMethod.POST)
    public void reg(@RequestParam(value = "username") String username,@RequestParam(value="password") String password,
                    @RequestParam(value = "password2") String password2,HttpServletRequest request, HttpServletResponse response) throws Exception{
        JSONObject jsonObj = null;

        UserService userService = new UserServiceImpl();
        if("".equals(username) || "".equals(password)){
            jsonObj = new JSONObject("{'code':'1','ext':'用户名和密码不能为空'}");
        }else if(!password.equals(password2)){
            jsonObj = new JSONObject("{'code':'2','ext':'两次输入密码不一致'}");
        }else {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            userService.newUser(user);
            jsonObj = new JSONObject("{'code':'0','ext':'注册成功'}");
        }

        response.setCharacterEncoding("utf8");
        PrintWriter pw = response.getWriter();
        pw.println(jsonObj);
    }

    @RequestMapping(value="/admin/login",method = RequestMethod.GET)
    public String toLogin(ModelMap modelMap){
        return "login";
    }

    @RequestMapping(value="/admin/login",method = RequestMethod.POST)
    public void login(@RequestParam(value = "username") String username,@RequestParam(value="password") String password,
                        HttpServletRequest request, HttpServletResponse response) throws Exception{
        JSONObject jsonObj = null;

        UserService userService = new UserServiceImpl();
        User user = userService.login(username, password);
        if(user != null){
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
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
        session.setAttribute("user", null);

        jsonObj = new JSONObject("{'code':'0','ext':'退出成功'}");

        response.setCharacterEncoding("utf8");
        PrintWriter pw = response.getWriter();
        pw.println(jsonObj);
    }

    @RequestMapping(value="/admin/success", method = RequestMethod.GET)
    public String toSuccess(ModelMap modelMap,HttpServletRequest request, HttpServletResponse response) throws Exception{
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if(user == null){
            //System.out.println("重定向");
            response.sendRedirect(request.getContextPath() + "/user/login");
            return null;
        }

        modelMap.put("username",user.getUsername());
        return "user/success";
    }
}
