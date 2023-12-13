package page_object;

import library.FunctionsSelenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailObject {

    WebDriver driver;

    @FindBy(id = "ap_email")
    WebElement userField;
    @FindBy(id = "continue")
    WebElement buttonContinuer;


    public EmailObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void enterUser(String username) {
        FunctionsSelenium.waitAndClick(driver, userField);
        userField.sendKeys(username);
    }

    public void clickContinuerButton() {
        FunctionsSelenium.waitAndClick(driver, buttonContinuer);
    }
}