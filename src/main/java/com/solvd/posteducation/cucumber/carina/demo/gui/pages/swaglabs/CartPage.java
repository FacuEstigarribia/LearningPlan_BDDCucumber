package com.solvd.posteducation.cucumber.carina.demo.gui.pages.swaglabs;

import com.solvd.posteducation.cucumber.carina.demo.gui.pages.swaglabs.components.CartItemComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartPage  extends AbstractPage {

    @FindBy(xpath = "(//div[@data-test='cart-list'])")
    private CartItemComponent cartItemComponent;
    @FindBy(xpath = "//button[@data-test='checkout']")
    private ExtendedWebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage clickCheckoutBtn(){
        checkoutBtn.click();
        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        return checkoutPage;
    }

    public CartItemComponent getCartItemComponent(){
        return cartItemComponent;
    }

}
