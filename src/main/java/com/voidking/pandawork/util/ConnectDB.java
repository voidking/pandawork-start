package com.voidking.pandawork.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by voidking on 2017/5/12.
 */
public class ConnectDB {
    private static volatile ConnectDB instance=null;
    private SqlSessionFactory sqlSessionFactory=null;

    private ConnectDB(){
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ConnectDB getInstance(){
        if(instance==null){
            synchronized(ConnectDB.class){
                if(instance==null){
                    instance=new ConnectDB();
                }
            }
        }
        return instance;
    }

    public SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
}
