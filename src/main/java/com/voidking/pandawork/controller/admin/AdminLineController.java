package com.voidking.pandawork.controller.admin;

import com.voidking.pandawork.entity.Admin;
import com.voidking.pandawork.entity.Line;
import com.voidking.pandawork.json.JSONObject;
import com.voidking.pandawork.service.LineService;
import com.voidking.pandawork.service.impl.LineServiceImpl;
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
public class AdminLineController {
    @RequestMapping(value="/admin/line/list", method = RequestMethod.GET)
    public String toManage(ModelMap modelMap,
                           HttpServletRequest request,
                           HttpServletResponse response) throws Exception{
        HttpSession session = request.getSession();
        Admin admin = (Admin)session.getAttribute("admin");
        if(admin == null){
            //System.out.println("重定向");
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return null;
        }

        modelMap.put("username",admin.getUsername());
        LineService lineService = new LineServiceImpl();
        List<Line> lineList = lineService.listAll();
        modelMap.put("lineList",lineList);
        return "admin/line/list";
    }

    @RequestMapping(value="/admin/line/search", method = RequestMethod.POST)
    public void lineSearch(@RequestParam(value = "key") String key,
                       HttpServletRequest request,
                       HttpServletResponse response) throws Exception{
        LineService lineService = new LineServiceImpl();
        List<Line> lineList = lineService.listByKey(key);

        JSONObject jsonObj = null;
        jsonObj = new JSONObject("{'code':'0','ext':'success'}");
        jsonObj.put("lineList", lineList);

        response.setCharacterEncoding("utf8");
        PrintWriter pw = response.getWriter();
        pw.println(jsonObj);
    }

    @RequestMapping(value="/admin/line/del", method = RequestMethod.POST)
    public void lineSearch(@RequestParam(value = "id") int id,
                           HttpServletRequest request,
                           HttpServletResponse response) throws Exception{
        LineService lineService = new LineServiceImpl();
        lineService.delLine(id);
        JSONObject jsonObj = null;
        jsonObj = new JSONObject("{'code':'0','ext':'success'}");
        response.setCharacterEncoding("utf8");
        PrintWriter pw = response.getWriter();
        pw.println(jsonObj);
    }

}
