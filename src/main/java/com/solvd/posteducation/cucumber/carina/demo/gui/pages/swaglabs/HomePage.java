package com.solvd.posteducation.cucumber.carina.demo.gui.pages.swaglabs;

import com.solvd.posteducation.cucumber.carina.demo.gui.pages.swaglabs.components.PrimaryHeaderComponent;
import com.solvd.posteducation.cucumber.carina.demo.gui.pages.swaglabs.components.ProductItemComponent;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "(//div[@data-test='primary-header'])")
    private PrimaryHeaderComponent primaryHeaderComponent;

    @FindBy(xpath = "(//div[@data-test='inventory-list'])")
    private ProductItemComponent productItemComponent;

    @FindBy(xpath = "//span[@data-test='title']")
    private ExtendedWebElement productsTitle;

    @FindBy(xpath = "//a[@data-test='shopping-cart-link']")
    private ExtendedWebElement cartIcon;

    @FindBy(xpath = "(//div[@data-test='inventory-list'])//div[@class='inventory_item']")
    private List<ExtendedWebElement> products;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(productsTitle);
    }

    public String getProductsTitle(){
        return productsTitle.getText();
    }


    public void addProductToCartStream(String productName) {
        //String productName = "Sauce Labs Bike Light";
        // Find the product element by name
        ExtendedWebElement productElement = products.stream()
                .filter(p -> {
                    ExtendedWebElement nameElement = p.findExtendedWebElement(By.xpath(".//div[@data-test='inventory-item-name']"));
                    return nameElement != null && nameElement.getText().equals(productName);
                })
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found: " + productName));

        // Find the 'Add to Cart' button within the product element and click it
        ExtendedWebElement addToCartButton = productElement.findExtendedWebElement(By.xpath(".//button[contains(@class, 'btn')]"));
        addToCartButton.click();
    }

    public CartPage clickCartIcon(){
        cartIcon.click();
        CartPage cartPage = new CartPage(getDriver());
        return cartPage;
    }

    public ProductItemComponent getProductItemComponent(){
        return productItemComponent;
    }

    public PrimaryHeaderComponent getPrimaryHeaderComponent(){
        return primaryHeaderComponent;
    }
}
