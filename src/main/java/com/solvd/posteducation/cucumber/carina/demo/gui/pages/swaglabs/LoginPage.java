package com.solvd.posteducation.cucumber.carina.demo.gui.pages.swaglabs;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {
    @FindBy(xpath = "//input[@id='user-name']")
    private ExtendedWebElement usernameField;
    @FindBy(xpath = "//input[@id='password']")
    private ExtendedWebElement passwordField;
    @FindBy(xpath = "//input[@id='login-button']")
    private ExtendedWebElement loginBtn;


    public LoginPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_URL);
    }


    public void typeUsername(){
        usernameField.type(R.TESTDATA.get("username"));
    }


    public void typePassword() {
        passwordField.type(R.TESTDATA.get("password"));
    }


    public HomePage clickLoginBtn() {
        loginBtn.click();
        HomePage homePage = new HomePage(getDriver());
        return homePage;
    }
}
