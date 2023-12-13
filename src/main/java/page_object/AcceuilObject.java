package page_object;

import library.FunctionsSelenium;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AcceuilObject {

    WebDriver driver;

    @FindBy(id = "gw-sign-in-button")
    WebElement buttonSeConnecter;

    @FindBy(id = "twotabsearchtextbox")
    WebElement SearchBar;

    @FindBy(id = "nav-search-submit-button")
    WebElement SubmitButton;


    @FindBy(id ="sp-cc-accept")
    WebElement cookiesButton;

    public AcceuilObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void clickCookiesButtonIsDisplayed() {
         if (FunctionsSelenium.waitDisplayingElement(driver, cookiesButton, 2)) {
             cookiesButton.click();
         }
    }

    public void clickButtonSeConnecter() {
        FunctionsSelenium.waitAndClick(driver, buttonSeConnecter);
    }
    
    public void clickSubmitButton() {
        FunctionsSelenium.waitAndClick(driver, SubmitButton);

    }

    public void clickSearchBar(String article) {

        FunctionsSelenium.waitAndClick(driver, SearchBar);
        SearchBar.sendKeys(article);
        SearchBar.sendKeys(Keys.ENTER);
    }
}
