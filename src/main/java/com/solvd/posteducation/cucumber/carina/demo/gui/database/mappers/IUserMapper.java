package com.solvd.posteducation.cucumber.carina.demo.gui.database.mappers;

import com.solvd.posteducation.cucumber.carina.demo.gui.database.models.User;

public interface IUserMapper {
    User findById(Long id);
}
