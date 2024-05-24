package com.solvd.posteducation.cucumber.carina.demo;

import com.solvd.posteducation.cucumber.carina.demo.gui.database.mappers.IUserMapper;
import com.solvd.posteducation.cucumber.carina.demo.gui.database.mappers.IUserOrdersMapper;
import com.solvd.posteducation.cucumber.carina.demo.gui.database.models.User;
import com.solvd.posteducation.cucumber.carina.demo.gui.database.models.UserOrder;
import com.solvd.posteducation.cucumber.carina.demo.gui.utils.ConnectionFactory;
import com.zebrunner.carina.core.IAbstractTest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.util.List;

public class DBSampleTest implements IAbstractTest {

    private static final Log LOGGER = LogFactory.getLog(DBSampleTest.class);

    @Test
    public void testGetUserById() {
        try (SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
            IUserMapper userMapper = session.getMapper(IUserMapper.class);
            User user = userMapper.findById(1L);
            LOGGER.info("Username: " + user.getUsername() + " password: " + user.getPassword());
            IUserOrdersMapper userOrderMapper = session.getMapper(IUserOrdersMapper.class);
            List<UserOrder> userOrder = userOrderMapper.findOrdersByUserId(1L);
            LOGGER.info(userOrder.size());
            for (UserOrder a : userOrder) {
                System.out.println(a.getProductName());
            }
        }
    }
}
