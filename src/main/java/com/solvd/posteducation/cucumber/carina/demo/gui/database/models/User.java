package com.solvd.posteducation.cucumber.carina.demo.gui.database.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Long zipCode;
    private List<UserOrder> orders = new ArrayList<>();

    public User() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Long getZipCode() {
        return zipCode;
    }
    public void setZipCode(Long zipCode) {
        this.zipCode = zipCode;
    }
    public List<UserOrder> getOrders() {
        return orders;
    }
    public void setOrders(List<UserOrder> orders) {
        this.orders = orders;
    }
}
