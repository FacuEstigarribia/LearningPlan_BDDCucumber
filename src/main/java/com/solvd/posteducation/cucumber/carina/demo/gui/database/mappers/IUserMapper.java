package com.solvd.posteducation.cucumber.carina.demo.gui.database.mappers;

import com.solvd.posteducation.cucumber.carina.demo.gui.database.models.User;

public interface IUserMapper {
    void create(User user);

    User findById(long id);

    User findByUserName(String username);

    void update(User user);

    void delete(User user);
}
