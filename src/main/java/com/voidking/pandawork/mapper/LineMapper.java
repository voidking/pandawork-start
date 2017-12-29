package com.voidking.pandawork.mapper;

import com.voidking.pandawork.entity.Line;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by voidking on 2017/5/8.
 */
public interface LineMapper {
    public int newLine(Line line);

    public int delLine(@Param("lineId") int lineId);

    public int updateLine(Line line);

    public Line queryByLineId(@Param("lineId") int lineId);

    public List<Line> listAll();

    public List<Line> listValid();

    public List<Line> listDeleted();

    public List<Line> listByPage(@Param("pageCurrent") int pageCurrent, @Param("pageSize") int pageSize);

    public List<Line> listByKey(@Param("key") String key);

    public int countLine();
}
