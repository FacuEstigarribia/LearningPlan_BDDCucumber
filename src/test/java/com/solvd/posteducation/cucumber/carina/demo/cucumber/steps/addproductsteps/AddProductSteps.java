package com.solvd.posteducation.cucumber.carina.demo.cucumber.steps.addproductsteps;

import com.solvd.posteducation.cucumber.carina.demo.gui.database.mappers.IOrderMapper;
import com.solvd.posteducation.cucumber.carina.demo.gui.database.mappers.IUserMapper;
import com.solvd.posteducation.cucumber.carina.demo.gui.database.models.User;
import com.solvd.posteducation.cucumber.carina.demo.gui.database.models.UserOrder;
import com.solvd.posteducation.cucumber.carina.demo.gui.pages.swaglabs.CartPage;
import com.solvd.posteducation.cucumber.carina.demo.gui.pages.swaglabs.HomePage;
import com.solvd.posteducation.cucumber.carina.demo.gui.pages.swaglabs.LoginPage;
import com.solvd.posteducation.cucumber.carina.demo.gui.pages.swaglabs.components.CartItemComponent;
import com.solvd.posteducation.cucumber.carina.demo.gui.pages.swaglabs.components.PrimaryHeaderComponent;
import com.solvd.posteducation.cucumber.carina.demo.gui.pages.swaglabs.components.ProductItemComponent;
import com.solvd.posteducation.cucumber.carina.demo.gui.utils.ConnectionFactory;
import com.zebrunner.carina.webdriver.IDriverPool;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.testng.Assert;

public class AddProductSteps implements IDriverPool {

    String mainUrl = "https://www.saucedemo.com/";
    private LoginPage loginPage;
    private HomePage homePage;
    private CartPage cartPage;
    private User user;

    @Given("I am on main page")
    public void iAmOnMainPage(){
        loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertEquals(loginPage.getCurrentUrl(), mainUrl, "Error on main page");
    }

    @When("I log in as {long} user")
    public void login(Long userId){
        String username = "";
        String password = "";
        SqlSessionFactory sqlSessionFactory = ConnectionFactory.getSqlSessionFactory();
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IUserMapper userMapper = session.getMapper(IUserMapper.class);
            user = userMapper.findById(userId);
            if (user != null) {
                username = user.getUsername();
                password = user.getPassword();
            }
        }
        loginPage.typeUsername(username);
        loginPage.typePassword(password);
        homePage = loginPage.clickLoginBtn();
    }

    @Then("Product page is opened")
    public void productPageIsOpened(){
        Assert.assertEquals(homePage.getProductsTitle(), "Products", "Product page is not opened");
    }

    @When("I add product to cart")
    public void addProductToCart(){
        try (SqlSession session = ConnectionFactory.getSqlSessionFactory().openSession(true)) {
            IOrderMapper orderMapper = session.getMapper(IOrderMapper.class);
            UserOrder order = orderMapper.findById(user.getId());
            ProductItemComponent productItem = homePage.getProductItemComponent();
            productItem.addProductToCartStream(order.getProductName());
            PrimaryHeaderComponent primaryHeaderComponent = homePage.getPrimaryHeaderComponent();
            cartPage = primaryHeaderComponent.clickCartIcon();
        }
    }

    @Then("I have an product in my cart")
    public void iHaveAnProductInMyCart(){
        CartItemComponent cartItemComponent = cartPage.getCartItemComponent();
        Assert.assertEquals(cartItemComponent.getProductText(),
                "Test.allTheThings() T-Shirt (Red)", "Error on product added");
    }
}
