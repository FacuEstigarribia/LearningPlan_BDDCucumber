package com.solvd.posteducation.cucumber.carina.demo.gui.pages.swaglabs.components;

import com.solvd.posteducation.cucumber.carina.demo.gui.pages.swaglabs.CartPage;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class PrimaryHeaderComponent extends AbstractUIObject {

    private static final String MAIN_LOCATOR = "(//div[@data-test='primary-header'])";

    @FindBy(xpath = MAIN_LOCATOR + "/div[@id='shopping_cart_container']")
    private ExtendedWebElement cartBtn;

    public PrimaryHeaderComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CartPage clickCartIcon(){
        cartBtn.click();
        CartPage cartPage = new CartPage(getDriver());
        return  cartPage;
    }
}
