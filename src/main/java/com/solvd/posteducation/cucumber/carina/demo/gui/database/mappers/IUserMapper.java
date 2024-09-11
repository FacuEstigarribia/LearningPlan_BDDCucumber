package com.solvd.posteducation.cucumber.carina.demo.gui.database.mappers;

import com.solvd.posteducation.cucumber.carina.demo.gui.database.models.User;
import org.apache.ibatis.annotations.Select;

public interface IUserMapper {
    void create(User user);

    User findById(long id);

    @Select("SELECT id, username, password, name, last_name, zip_code FROM User WHERE username = #{username}")
    User findByUsername(String username);

    void update(User user);

    void delete(User user);
}
