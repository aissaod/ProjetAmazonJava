package page_object;

import library.FunctionsSelenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArticleObject {

     WebDriver driver;


    @FindBy(id = "add-to-cart-button")
    WebElement AddToCardButton;

    @FindBy(id = "attachSiNoCoverage")
    WebElement NonMerciButton;

    @FindBy(id ="attach-sidesheet-view-cart-button")
    WebElement PanierButton;


    public ArticleObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void AddToCardButton() {
        AddToCardButton.click();
    }

    public void NonMerciButton() {
        FunctionsSelenium.waitAndClick(driver, NonMerciButton);
    }

    public void PanierButton() {
        FunctionsSelenium.waitAndClick(driver, PanierButton);
    }


}