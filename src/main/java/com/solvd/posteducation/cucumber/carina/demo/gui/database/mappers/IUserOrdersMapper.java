package com.solvd.posteducation.cucumber.carina.demo.gui.database.mappers;

import com.solvd.posteducation.cucumber.carina.demo.gui.database.models.UserOrder;

import java.util.List;

public interface IUserOrdersMapper {
    UserOrder findById(Long id);
    List<UserOrder> findOrdersByUserId(Long id);
}
