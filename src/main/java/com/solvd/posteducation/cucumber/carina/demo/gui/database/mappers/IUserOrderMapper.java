package com.solvd.posteducation.cucumber.carina.demo.gui.database.mappers;

import com.solvd.posteducation.cucumber.carina.demo.gui.database.models.UserOrder;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserOrderMapper {

    UserOrder findById(Long id);

    //@Select("SELECT * FROM UserOrders WHERE user_id = #{userId}")
    List<UserOrder> findOrdersByUserId(Long id);
}
