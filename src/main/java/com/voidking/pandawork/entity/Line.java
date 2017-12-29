package com.voidking.pandawork.entity;

/**
 * Created by voidking on 2017/12/28.
 */
public class Line implements Cloneable{
    private int id;
    private String busName;
    private String fullName;
    private String firstStop;
    private String lastStop;
    private int deleted;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getBusName() {
        return busName;
    }
    public void setBusName(String busName) {
        this.busName = busName;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public String getFirstStop() {
        return firstStop;
    }
    public void setFirstStop(String firstStop) {
        this.firstStop = firstStop;
    }
    public String getLastStop() {
        return lastStop;
    }
    public void setLastStop(String lastStop) {
        this.lastStop = lastStop;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public Line(int id, String busName, String fullName, String firstStop, String lastStop, int deleted) {
        super();
        this.id = id;
        this.busName = busName;
        this.fullName = fullName;
        this.firstStop = firstStop;
        this.lastStop = lastStop;
        this.deleted = deleted;
    }

    public Line() {
        super();
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {
        return super.clone();
    }
}
