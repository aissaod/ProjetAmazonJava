package page_object;

import library.FunctionsSelenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PasserCommandeObject {

    WebDriver driver;


    @FindBy(id="bottomSubmitOrderButtonId") WebElement PasserVotreCommandeButton;
    @FindBy(id = "a-autoid-4-announce")
    WebElement continuerSansPrime;

    public PasserCommandeObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void PasserVotreCommandeButton() {
        PasserVotreCommandeButton.click();
    }
    public void ContinuerSansPrime() {
        FunctionsSelenium.waitAndClick(driver, continuerSansPrime);
    }
}