package com.solvd.posteducation.cucumber.carina.demo.gui.pages.swaglabs.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartItemComponent extends AbstractUIObject {

    private static final String MAIN_LOCATOR = "(//div[@data-test='cart-list'])";

    @FindBy(xpath = MAIN_LOCATOR + "//div[@data-test='inventory-item-name' and text()='Test.allTheThings() T-Shirt (Red)']")
    private ExtendedWebElement productText;

    public CartItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductText(){
        return productText.getText();
    }
}
