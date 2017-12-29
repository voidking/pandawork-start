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

        modelMap.put("admin",admin);
        LineService lineService = new LineServiceImpl();
        List<Line> lineList = lineService.listValid();
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

    @RequestMapping(value="/admin/line/add", method = RequestMethod.GET)
    public String toAdd(ModelMap modelMap,
                        HttpServletRequest request,
                        HttpServletResponse response) throws Exception{
        HttpSession session = request.getSession();
        Admin admin = (Admin)session.getAttribute("admin");
        if(admin == null){
            //System.out.println("重定向");
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return null;
        }

        modelMap.put("admin",admin);
        return "admin/line/add";
    }

    @RequestMapping(value="/admin/line/add", method = RequestMethod.POST)
    public void add(@RequestParam(value = "busName") String busName,
                    @RequestParam(value = "fullName") String fullName,
                    @RequestParam(value = "firstStop") String firstStop,
                    @RequestParam(value = "lastStop") String lastStop,
                    HttpServletRequest request,
                    HttpServletResponse response) throws Exception{
        LineService lineService = new LineServiceImpl();
        Line line = new Line(0,busName,fullName,firstStop,lastStop,0);
        int flag = lineService.newLine(line);
        JSONObject jsonObj = null;
        if(flag == 1){
            jsonObj = new JSONObject("{'code':'0','ext':'success'}");
            jsonObj.put("id",line.getId());
        }else{
            jsonObj = new JSONObject("{'code':'-1','ext':'fail'}");
        }
        response.setCharacterEncoding("utf8");
        PrintWriter pw = response.getWriter();
        pw.println(jsonObj);


    }

    @RequestMapping(value="/admin/line/del", method = RequestMethod.POST)
    public void lineSearch(@RequestParam(value = "id") int id,
                           HttpServletRequest request,
                           HttpServletResponse response) throws Exception{
        LineService lineService = new LineServiceImpl();
        int flag = lineService.delLine(id);
        JSONObject jsonObj = null;

        if(flag == 1){
            jsonObj = new JSONObject("{'code':'0','ext':'success'}");
        }else{
            jsonObj = new JSONObject("{'code':'-1','ext':'fail'}");
        }

        response.setCharacterEncoding("utf8");
        PrintWriter pw = response.getWriter();
        pw.println(jsonObj);
    }

    @RequestMapping(value="/admin/line/update", method = RequestMethod.POST)
    public void update(@RequestParam(value = "id") int id,
                    @RequestParam(value = "busName") String busName,
                    @RequestParam(value = "fullName") String fullName,
                    @RequestParam(value = "firstStop") String firstStop,
                    @RequestParam(value = "lastStop") String lastStop,
                    HttpServletRequest request,
                    HttpServletResponse response) throws Exception{
        LineService lineService = new LineServiceImpl();
        Line line = new Line(id,busName,fullName,firstStop,lastStop,0);
        int flag = lineService.updateLine(line);
        JSONObject jsonObj = null;
        if(flag == 1){
            jsonObj = new JSONObject("{'code':'0','ext':'success'}");
            jsonObj.put("id",line.getId());
        }else{
            jsonObj = new JSONObject("{'code':'-1','ext':'fail'}");
        }
        response.setCharacterEncoding("utf8");
        PrintWriter pw = response.getWriter();
        pw.println(jsonObj);


    }

}
