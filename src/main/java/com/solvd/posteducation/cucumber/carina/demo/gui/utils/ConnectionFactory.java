package com.solvd.posteducation.cucumber.carina.demo.gui.utils;


import java.io.IOException;
import java.io.Reader;

import com.solvd.posteducation.cucumber.carina.demo.gui.database.mappers.IOrderMapper;
import com.solvd.posteducation.cucumber.carina.demo.gui.database.mappers.IUserOrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.solvd.posteducation.cucumber.carina.demo.gui.database.mappers.IUserMapper;

public class ConnectionFactory {
    private static SqlSessionFactory factory;

    static {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis_config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        factory = new SqlSessionFactoryBuilder().build(reader);
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return factory;
    }

    public static IUserMapper getIUserMapper() {
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(IUserMapper.class);
    }

    public static IUserOrderMapper getIUserOrdersMapper() {
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(IUserOrderMapper.class);
    }

    public static IOrderMapper getIOrderMapper(){
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(IOrderMapper.class);
    }
}
