package com.solvd.posteducation.cucumber.carina.demo.gui.pages.swaglabs;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends AbstractPage {

    @FindBy(xpath = "//input[@data-test='firstName']")
    private ExtendedWebElement nameField;

    @FindBy(xpath = "//input[@data-test='lastName']")
    private ExtendedWebElement lastNameField;

    @FindBy(xpath = "//input[@data-test='postalCode']")
    private ExtendedWebElement zipCodeField;

    @FindBy(xpath = "//input[@data-test='continue']")
    private ExtendedWebElement continueBtn;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void typeName(String name) {
        nameField.type(name);
    }

    public void typeLastName(String lastName) {
        lastNameField.type(lastName);
    }

    public void typeZipCode(String code) {
        zipCodeField.type(code);
    }

    public CheckoutOverviewPage clickContinueBtn(){
        continueBtn.click();
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(getDriver());
        return  checkoutOverviewPage;
    }
}
