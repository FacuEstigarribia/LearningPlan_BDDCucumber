package com.solvd.posteducation.cucumber.carina.demo.cucumber.steps;

import com.solvd.posteducation.cucumber.carina.demo.gui.pages.swaglabs.HomePage;
import com.solvd.posteducation.cucumber.carina.demo.gui.pages.swaglabs.LoginPage;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.IDriverPool;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTest implements IDriverPool {
    static LoginPage loginPage = null;
    static HomePage homePage = null;
    @Given("I am on LoginPage")
    public boolean iAmOnLoginPage(){
        loginPage = new LoginPage(getDriver());
        loginPage.open();
        return loginPage.isPageOpened();
    }
    @When("Type valid username and password")
    public void typeUsarnmeAndPassword(){
        loginPage.typeUsername();
        loginPage.typePassword();
    }

    @When("Cick Login button")
    public HomePage clickLoginButton(){
        HomePage homePage = loginPage.clickLoginBtn();
        return homePage;
    }

    @Then("HomePage must be opened checked by Products title")
    public boolean isHomePageOpened(){
        HomePage homePage = new HomePage(getDriver());
        return homePage.isPageOpened();
    }
}
