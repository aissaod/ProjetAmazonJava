package page_object;

import library.FunctionsSelenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordObject {

    WebDriver driver;


    @FindBy(id = "ap_password")
    WebElement passwordInput;

    @FindBy(name = "rememberMe")
    WebElement buttonResterConnecte;

    @FindBy(id = "signInSubmit")
    WebElement loginButton;


    public PasswordObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void enterPassword(String password) {
        FunctionsSelenium.waitAndClick(driver, passwordInput);
    }


    public void clickResterConnecteButton() {
        FunctionsSelenium.waitAndClick(driver, buttonResterConnecte);
    }

    public void clickLoginButton() {
        FunctionsSelenium.waitAndClick(driver, loginButton);
    }

}