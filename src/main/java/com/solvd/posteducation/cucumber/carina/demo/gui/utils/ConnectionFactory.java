package com.solvd.posteducation.cucumber.carina.demo.gui.utils;


import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.solvd.posteducation.cucumber.carina.demo.gui.database.mappers.IUserMapper;
import com.solvd.posteducation.cucumber.carina.demo.gui.database.mappers.IUserOrdersMapper;

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

    public static IUserOrdersMapper getIUserOrdersMapper() {
        return ConnectionFactory.getSqlSessionFactory().openSession(true).getMapper(IUserOrdersMapper.class);
    }
}
