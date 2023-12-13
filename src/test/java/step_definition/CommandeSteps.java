package step_definition;

import factory.WebDriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page_object.AcceuilObject;
import page_object.ArticleObject;
import page_object.ElementsObject;
import page_object.PanierObject;


public class CommandeSteps extends WebDriverFactory{



    @Given("j'ai réussi à me connecter sur mon compte Amazon")
    public void jeSuisSurLaPageAcceuilAmazon() {

    }

    @When("je recherche {string} dans la barre de recherche")
    public void jeRechercheDansLaBarreDeRecherche(String article) {
        new AcceuilObject(driver).clickSearchBar(article);
    }

    @And("je clique sur rechercher")
    public void jeCliqueSurRechercher() {
        new AcceuilObject(driver).clickSubmitButton();
    }

    @And("^je clique sur l'article \"(.*?)\"$")
    public void jeCliqueSurArticle(String articleName) {
        new ElementsObject(driver).clickOnOrder(articleName);
    }

    @Then("je devrais etre redirigé vers ce produit")
    public void jeDevraisEtreRedirigeVersProduit() {

    }

    @Given("je suis sur la page de mon article")
    public void jeSuisSurLaPageDeMonArticle() {

    }

    @And("que je souhaite acheter l'article")
    public void jeSouhaiteAcheterArticle() {

    }

    @When("je clique sur le bouton \"Ajouter au panier\"")
    public void jeCliqueSurBoutonAjouterAuPanier() {
        new ArticleObject(driver).AddToCardButton();
    }

    @And("je clique sur \"Non Merci\"")
    public void jeCliqueSurNonMerci() {
        new ArticleObject(driver).NonMerciButton();
    }

    @And("je clique sur \"Panier\"")
    public void jeCliqueSurPanier() {
        new ArticleObject(driver).PanierButton();

    }

    @Then("le produit doit etre dans mon panier et je peux passer à la commande")
    public void leProduitDoitEtreDansMonPanier() {

    }

}
