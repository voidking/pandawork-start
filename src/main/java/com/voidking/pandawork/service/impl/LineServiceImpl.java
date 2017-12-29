package com.voidking.pandawork.service.impl;

import com.voidking.pandawork.entity.Line;
import com.voidking.pandawork.mapper.LineMapper;
import com.voidking.pandawork.service.LineService;
import com.voidking.pandawork.util.ConnectDB;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by voidking on 2017/12/28.
 */
public class LineServiceImpl implements LineService {
    private SqlSessionFactory sqlSessionFactory = null;
    private LineMapper lineMapper = null;

    public LineServiceImpl(){
        sqlSessionFactory = ConnectDB.getInstance().getSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        lineMapper = session.getMapper(LineMapper.class);
    }

    public void newLine(Line line) {
        lineMapper.newLine(line);
    }

    public void delLine(int lineId) {
        lineMapper.delLine(lineId);
    }

    public void updateLine(Line line) {
        lineMapper.updateLine(line);
    }

    public Line queryByLineId(int lineId) {
        Line line = lineMapper.queryByLineId(lineId);
        return line;
    }

    public List<Line> listAll() {
        List<Line> lineList = lineMapper.listAll();
        return lineList;
    }

    public List<Line> listValid(){
        List<Line> lineList = lineMapper.listValid();
        return lineList;
    }

    public List<Line> listDeleted(){
        List<Line> lineList = lineMapper.listDeleted();
        return lineList;
    }

    public List<Line> listByPage(int pageNum, int pageSize) {
        List<Line> lineList = lineMapper.listByPage((pageNum-1)*pageSize,pageSize);
        return lineList;
    }

    public List<Line> listByKey(String key) {
        List<Line> lineList = lineMapper.listByKey(key);
        return lineList;
    }

    public int countLine() {
        int result = lineMapper.countLine();
        return result;
    }
}
