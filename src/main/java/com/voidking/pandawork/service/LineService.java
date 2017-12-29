package com.voidking.pandawork.service;

import com.voidking.pandawork.entity.Line;

import java.util.List;

/**
 * Created by voidking on 2017/12/28.
 */
public interface LineService {
    public int newLine(Line line);

    public int delLine(int lineId);

    public int updateLine(Line line);

    public Line queryByLineId(int lineId);

    public List<Line> listAll();

    public List<Line> listValid();

    public List<Line> listDeleted();

    public List<Line> listByPage(int pageNum, int pageSize);

    public List<Line> listByKey(String key);

    public int countLine();
}
