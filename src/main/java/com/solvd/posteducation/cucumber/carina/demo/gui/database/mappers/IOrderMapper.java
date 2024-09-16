package com.solvd.posteducation.cucumber.carina.demo.gui.database.mappers;

import com.solvd.posteducation.cucumber.carina.demo.gui.database.models.UserOrder;

public interface IOrderMapper {

    void create(UserOrder userOrder);
    UserOrder findById(Long id);
    void delete(Long id);
    void update(UserOrder userOrder);
}
