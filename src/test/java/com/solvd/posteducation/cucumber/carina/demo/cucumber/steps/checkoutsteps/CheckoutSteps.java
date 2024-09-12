package com.solvd.posteducation.cucumber.carina.demo.cucumber.steps.checkoutsteps;

import com.solvd.posteducation.cucumber.carina.demo.gui.database.mappers.IUserMapper;
import com.solvd.posteducation.cucumber.carina.demo.gui.database.mappers.IUserOrderMapper;
import com.solvd.posteducation.cucumber.carina.demo.gui.database.models.User;
import com.solvd.posteducation.cucumber.carina.demo.gui.database.models.UserOrder;
import com.solvd.posteducation.cucumber.carina.demo.gui.pages.swaglabs.*;
import com.solvd.posteducation.cucumber.carina.demo.gui.utils.ConnectionFactory;
import com.zebrunner.carina.webdriver.IDriverPool;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.testng.Assert;

import java.util.List;

public class CheckoutSteps implements IDriverPool {


    private static SqlSessionFactory sqlSessionFactory;
    private IUserMapper userMapper = null;
    private IUserOrderMapper userOrdersMapper = null;
    private User user = null;
    private LoginPage loginPage = null;
    private HomePage homePage = null;
    private CartPage cartPage = null;
    private CheckoutPage checkoutPage = null;
    private CheckoutOverviewPage checkoutOverviewPage = null;
    private CheckoutCompletePage checkoutCompletePage = null;


    @Given("the user is logged in with valid {string} and {string}")
    public void theUserIsLoggedInWithValidCredentials(String username, String password) {
        loginPage = new LoginPage(getDriver());
        loginPage.open();
        if (username.equals("<username>")) {
            sqlSessionFactory = ConnectionFactory.getSqlSessionFactory();
            try (SqlSession session = sqlSessionFactory.openSession()){
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

    @When("^the user adds items to the cart$")
    public void theUserAddsItemsToTheCart() {
        sqlSessionFactory = ConnectionFactory.getSqlSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()){
            userOrdersMapper = session.getMapper(IUserOrderMapper.class);
            UserOrder order = userOrdersMapper.findById(1L);
            homePage.addProductToCartStream(order.getProductName());
        }
    }

    @And("^the user click on cart button$")
    public void theUserClickOnTheCartButton(){
        cartPage = homePage.clickCartIcon();
    }

    @And("^the user proceeds to checkout$")
    public void theUserProceedsToCheckout() {
        checkoutPage = cartPage.clickCheckoutBtn();
    }

    @And("^the user provides valid shipping information$")
    public void theUserProvidesValidShippingInformation(){
        checkoutPage.typeName(user.getName());
        checkoutPage.typeLastName(user.getLastName());
        checkoutPage.typeZipCode(user.getZipCode());
    }

    @And("^the user click on continue button$")
    public void theUserClickOnContinueButton(){
        checkoutOverviewPage = checkoutPage.clickContinueBtn();
    }

    @And("^the user confirms the order$")
    public void theUserConfirmsTheOrder(){
        checkoutCompletePage = checkoutOverviewPage.clickFinishBtn();
    }

    @Then("^the user should see the order confirmation page$")
    public void theUserShouldSeeTheOrderConfirmationPage(){
        Assert.assertEquals(checkoutCompletePage.getCheckoutCompleteTitle(), "Checkout: Complete!", "Error");
    }

    @And("^the order should be saved in the database$")
    public void theOrderShouldBeSavedInTheDatabase(){
        IUserOrderMapper userOrdersMapper = ConnectionFactory.getIUserOrdersMapper();
        List<UserOrder> orders = userOrdersMapper.findOrdersByUserId(1L);
        Assert.assertFalse(orders.isEmpty(), "No orders found for user in the database");
        UserOrder lastOrder = orders.get(orders.size() - 1);
        Assert.assertEquals(lastOrder.getProductName(), "Sauce Labs Backpack");
    }
}
