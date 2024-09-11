package com.solvd.posteducation.cucumber.carina.demo.cucumber.steps.dbsteps;

import com.solvd.posteducation.cucumber.carina.demo.gui.database.mappers.IUserMapper;
import com.solvd.posteducation.cucumber.carina.demo.gui.database.models.User;
import com.solvd.posteducation.cucumber.carina.demo.gui.pages.swaglabs.HomePage;
import com.solvd.posteducation.cucumber.carina.demo.gui.pages.swaglabs.LoginPage;
import com.solvd.posteducation.cucumber.carina.demo.gui.utils.ConnectionFactory;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.IDriverPool;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginTestDB implements IDriverPool {

    private WebDriver driver = getDriver();
    private static LoginPage loginPage = null;
    private static HomePage homePage = null;
    private IUserMapper userMapper;

    @Given("I am on the Sauce Demo login page")
    public boolean iAmOnTheSaucedemoLoginPage(){
        loginPage = new LoginPage(driver);
        loginPage.open();
        return loginPage.isPageOpened();
    }

    @When("I log in with username {string} and password {string}")
    public void iLoginWithUsernameAndPassword(String username, String password){

        if (username.equals("<username>")) {
            SqlSessionFactory sqlSessionFactory = ConnectionFactory.getSqlSessionFactory();
            try (SqlSession session = sqlSessionFactory.openSession()) {
                userMapper = session.getMapper(IUserMapper.class);
                User user = userMapper.findByUsername(username);
                if (user != null) {
                    username = user.getUsername();
                    password = user.getPassword();
                }
            }
        }
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        homePage = loginPage.clickLoginBtn();
    }


    @Then("I should see the Sauce Labs products page")
    public void iShouldSeeTheSauceLabsProductsPage(){
        Assert.assertEquals(homePage.getProductsTitle(), "Products", "Error");
    }
}
