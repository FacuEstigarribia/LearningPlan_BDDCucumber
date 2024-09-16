package com.solvd.posteducation.cucumber.carina.demo.gui.pages.swaglabs.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductItemComponent extends AbstractUIObject {

    private static final String MAIN_LOCATOR = "(//div[@data-test='inventory-list'])";
    @FindBy(xpath = MAIN_LOCATOR + "//div[@class='inventory_item']")
    private List<ExtendedWebElement> products;


    public ProductItemComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void addProductToCartStream(String productName) {


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

}
