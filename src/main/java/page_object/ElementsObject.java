package page_object;

import library.FunctionsSelenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsObject {

    private WebDriver driver;

    @FindBy(css = "span[data-component-type='s-search-results'] div[data-asin][data-component-type='s-search-result'] h2 a")
    private WebElement orderLink;

    public ElementsObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnOrder(String orderName) {
        FunctionsSelenium.waitAndClick(driver, orderLink);
    }
}
