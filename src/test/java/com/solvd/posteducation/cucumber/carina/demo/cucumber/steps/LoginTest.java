package com.solvd.posteducation.cucumber.carina.demo.cucumber.steps;

import com.solvd.posteducation.cucumber.carina.demo.gui.pages.swaglabs.HomePage;
import com.solvd.posteducation.cucumber.carina.demo.gui.pages.swaglabs.LoginPage;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.IDriverPool;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.sql.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest implements IDriverPool {
    WebDriver driver = getDriver();
    static LoginPage loginPage = null;
    static HomePage homePage = null;

    @Given("^I am on LoginPage of Saucedemo website$")
    public boolean iAmOnLoginPage(){
        loginPage = new LoginPage(driver);
        loginPage.open();
        return loginPage.isPageOpened();
    }

    @When("^User type username and password$")
    public void userTypeUsernameAndPassword(){
        loginPage.typeUsername("standard_user");
        loginPage.typePassword("secret_sauce");
    }
    @And("^User click on Login button$")
    public void userClickOnLoginButton(){
        homePage = loginPage.clickLoginBtn();
    }

    @Then("^HomePage must be open$")
    public boolean homePageMustBeOpen(){
        return homePage.isPageOpened();
    }
}
