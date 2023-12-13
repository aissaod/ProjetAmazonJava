package step_definition;

import factory.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page_object.PanierObject;
import page_object.PasserCommandeObject;

import static step_definition.CommandeSteps.driver;

public class PaiementSteps  extends WebDriverFactory {


    @Given("j'ai ajouté au panier tout mes articles")
    public void jAiAjouteAuPanierTousMesArticles() {

    }

    @And("que je souhaite passer au paiement")
    public void jeSouhaitePasserAuPaiement() {

    }

    @When("je clique sur passer la commande")
    public void jeCliqueSurPasserLaCommande() {
        new PanierObject(driver).PasserVotreCommandeButton();
    }
    @And("je cliquer sur \"Continuer sans Prime\"")
    public void continuerSansPrime() {
        new PasserCommandeObject(driver).ContinuerSansPrime();
    }

    @Then("je devrais etre redirigé vers la page de paiement")
    public void jeDevraisEtreRedirigeVersPagePaiement() {

    }

    @And("mes articles devraient etre recapitules")
    public void mesArticlesDevraientEtreRecapitules() {

    }
}