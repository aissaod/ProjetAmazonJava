package page_object;

    import library.FunctionsSelenium;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.FindBy;
    import org.openqa.selenium.support.PageFactory;

public class PanierObject {

    WebDriver driver;


    @FindBy(id = "sc-buy-box-ptc-button") WebElement PasserVotreCommandeButton;


    public PanierObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void PasserVotreCommandeButton() {
        FunctionsSelenium.waitAndClick(driver, PasserVotreCommandeButton);
    }
}