package com.voidking.pandawork;

import com.voidking.pandawork.entity.Line;
import com.voidking.pandawork.service.LineService;
import com.voidking.pandawork.service.impl.LineServiceImpl;
import junit.framework.TestCase;

import java.util.List;

/**
 * Created by voidking on 2017/5/12.
 */
public class LineServiceTest extends TestCase {
    private LineService lineService = null;

    public void setUp() throws Exception {
        super.setUp();
        lineService = new LineServiceImpl();
    }

    public void testNewLine() throws Exception {
        Line line = new Line();
        lineService.newLine(line);
    }

    public void testDelLine() throws Exception {
        lineService.delLine(2);
    }

    public void testUpdateLine() throws Exception {
        Line line = lineService.queryByLineId(1);
        lineService.updateLine(line);

    }

    public void testQueryByLineId() throws Exception {
        Line line = lineService.queryByLineId(1);
        System.out.println(line.getId());
    }

    public void testListAll() throws Exception {
        List<Line> lineList = lineService.listAll();
        System.out.println(lineList.size());
    }

    public void testListByPage() throws Exception {
        List<Line> lineList = lineService.listByPage(2, 3);
        for(Line line: lineList){
            System.out.print(line.getId()+"\t");
        }
    }

    public void testListByKey() throws Exception {
        List<Line> lineList = lineService.listByKey("voi");
        for(Line line: lineList){
            System.out.print(line.getId()+"\t");
        }
    }

    public void testCountLine() throws Exception {
        int count = lineService.countLine();
        System.out.println(count);
    }

}