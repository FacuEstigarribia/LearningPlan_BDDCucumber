package com.solvd.posteducation.cucumber.carina.demo.gui.database.models;

public class UserOrder {
    private Long id;
    private String productName;
    private Double productPrice;

    public UserOrder() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Double getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
}
