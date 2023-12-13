package step_definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import log4j.log4jTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_object.AcceuilObject;
import page_object.EmailObject;
import page_object.PasswordObject;
import factory.WebDriverFactory;



public class LoginSteps extends WebDriverFactory {
    private static Logger logger = LogManager.getLogger(LoginSteps.class.getName());


    @Given("je suis sur la page d'acceuil Amazon, je souhaite m'identifier")
    public void jeSuisSurLaPageAcceuilAmazon() {
       // System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
        //driver = new ChromeDriver();
       // driver.get("https://www.amazon.fr/");
    setupBrowser("chrome", "https://www.amazon.fr/" );
        logger.info("affiche la page amazon");
        new AcceuilObject(driver).clickCookiesButtonIsDisplayed();


    }

    @When("je clique sur \"Se connecter en toute sécurité\"")
    public void jeCliqueSurSeConnecter() {
        new AcceuilObject(driver).clickButtonSeConnecter();

    }


    @Then("je suis redirigé vers la page S'identifier")
    public void jeSuisRedirigeVersLaPageIdentification() {


    }

    @Given("je suis sur la page S'identifier")
    public void jeSuisSurLaPageIdentification() {
        //  System.out.println("Page identification trouvée");
    }

    @When("je saisis mon user {string}")
    public void entrerNomUtilisateurValide(String user) {
        new EmailObject(driver).enterUser(user);

    }

    @And("je clique Sur le bouton \"Continuer\"")
    public void jeCliqueSurLeBoutonContinuer() {
        new EmailObject(driver).clickContinuerButton();
    }

    @And("je saisis mon password {string}")
    public void entrerMotDePasseValide(String password) {
        new PasswordObject(driver).enterPassword(password);
    }


    @And("je clique sur \"Rester connecté\"")
    public void jeCliqueSurResterConnecter() {
        new PasswordObject(driver).clickResterConnecteButton();
    }

    @And("je clique sur \"S'identifier\"")
    public void jeCliqueSurIdentifier() {
        new PasswordObject(driver).clickLoginButton();
    }

    @Then("je suis redirigé vers la page d'acceuil amazon")
    public void jeSuisRedirigeVersLaPageAcceuilAmazon() {
    }
}