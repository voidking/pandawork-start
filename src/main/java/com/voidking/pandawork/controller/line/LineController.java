package com.voidking.pandawork.controller.line;

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
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by voidking on 2017/12/28.
 */
@Controller
public class LineController {

    @RequestMapping(value="/line/home", method = RequestMethod.GET)
    public String toHome(ModelMap modelMap,
                         HttpServletRequest request,
                         HttpServletResponse response) throws Exception{

        LineService lineService = new LineServiceImpl();
        List<Line> lineList = lineService.listValid();
        modelMap.put("lineList",lineList);
        return "line/home";
    }

    @RequestMapping(value="/line/search", method = RequestMethod.POST)
    public void search(@RequestParam(value = "key") String key,
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


    @RequestMapping(value="/line/direction", method = RequestMethod.GET)
    public String toDirection(@RequestParam(value = "id") int id,
                              ModelMap modelMap, HttpServletRequest request,
                              HttpServletResponse response) throws Exception{

        LineService lineService = new LineServiceImpl();
        Line line = lineService.queryByLineId(id);
        modelMap.put("line",line);
        return "line/direction";
    }

    @RequestMapping(value="/line/stop", method = RequestMethod.GET)
    public String toStop(@RequestParam(value = "id") int id,
                         @RequestParam(value = "busName") String busName,
                         @RequestParam(value = "firstStop") String firstStop,
                         ModelMap modelMap,
                         HttpServletRequest request,
                              HttpServletResponse response) throws Exception{

//        LineService lineService = new LineServiceImpl();
//        Line line = lineService.queryByLineId(id);
//        modelMap.put("line",line);

        modelMap.put("busName",busName);
        modelMap.put("firstStop",firstStop);
        return "line/stop";
    }

}
