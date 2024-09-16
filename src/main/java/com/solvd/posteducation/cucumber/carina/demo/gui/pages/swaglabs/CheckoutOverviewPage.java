package com.solvd.posteducation.cucumber.carina.demo.gui.pages.swaglabs;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends AbstractPage {

    @FindBy(xpath = "//button[@data-test='finish']")
    private ExtendedWebElement finishBtn;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutCompletePage clickFinishBtn(){
        finishBtn.click();
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(getDriver());
        return checkoutCompletePage;
    }
}
