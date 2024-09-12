package com.solvd.posteducation.cucumber.carina.demo.gui.pages.swaglabs;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends AbstractPage {

    @FindBy(xpath = "//span[@data-test='title']")
    private ExtendedWebElement checkoutCompleteTitle;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }


    public String getCheckoutCompleteTitle(){
        return checkoutCompleteTitle.getText();
    }
}
