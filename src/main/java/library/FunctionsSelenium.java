package library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FunctionsSelenium {
    public static final int timeouts = 10;

    /**
     * Méthode qui permet de mettre en pause le programme de quelques secondes
     * @param nbSecondes nombre de secondes
     */
    public static void pauseProgram(int nbSecondes) {
        try {
            Thread.sleep(nbSecondes * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Attends l'affichage de l'élément spécifié pendant un certain nombre de secondes.
     * @param driver le pilote WebDriver
     * @param element l'élément à attendre
     * @param nbrSecondes le nombre de secondes à attendre
     * @return vrai si l'élément est affiché, sinon faux
     */
    public static boolean waitDisplayingElement(WebDriver driver, WebElement element, int nbrSecondes) {
        try {
            new WebDriverWait(driver, nbrSecondes).until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Attends la possibilité de cliquer sur l'élément spécifié pendant un certain nombre de secondes.
     * @param driver le pilote WebDriver
     * @param element l'élément à attendre
     * @param nbrSecondes le nombre de secondes à attendre
     * @return vrai si l'élément est cliquable, sinon faux
     */
    public static boolean waitClickableElement(WebDriver driver, WebElement element, int nbrSecondes) {
        try {
            new WebDriverWait(driver, nbrSecondes).until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Attends l'affichage et la possibilité de cliquer sur l'élément spécifié pendant un certain nombre de secondes.
     * @param driver le pilote WebDriver
     * @param element l'élément à attendre et cliquer
     * @param nbrSecondes le nombre de secondes à attendre
     */
    public static void waitAndClick(WebDriver driver, WebElement element, int nbrSecondes) {
        boolean objectDisplayed = waitDisplayingElement(driver, element, nbrSecondes);
        Assert.assertTrue(objectDisplayed, "Element non affiché");
        boolean objectClickable = waitClickableElement(driver, element, nbrSecondes);
        Assert.assertTrue(objectClickable, "Element non clickable");
        element.click();
    }

    /**
     * Attends l'affichage et la possibilité de cliquer sur l'élément spécifié en utilisant le délai par défaut.
     * @param driver le pilote WebDriver
     * @param element l'élément à attendre et cliquer
     */
    public static void waitAndClick(WebDriver driver, WebElement element) {
        waitAndClick(driver, element, timeouts);
    }

    /**
     * Effectue une saisie de texte dans un champ de saisie WebElement.
     *
     * @param element le champ de saisie WebElement
     * @param text la chaîne de texte à saisir
     */
    public static void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }

    /**
     * Récupère le texte d'un élément WebElement.
     *
     * @param element l'élément WebElement dont on veut récupérer le texte
     * @return le texte de l'élément
     */
    public static String getText(WebElement element) {
        return element.getText();
    }

    /**
     * Vérifie si un texte est présent dans la page affichée par le WebDriver.
     *
     * @param driver le pilote WebDriver
     * @param text le texte à rechercher
     * @return vrai si le texte est présent, sinon faux
     */
    public static boolean isTextPresent(WebDriver driver, String text) {
        return driver.getPageSource().contains(text);
    }

    /**
     * Vérifie la présence d'un élément dans la page.
     *
     * @param driver le pilote WebDriver
     * @param locator le locator de l'élément à vérifier
     */
    public static void assertElementPresent(WebDriver driver, By locator) {
        Assert.assertTrue(driver.findElements(locator).size() > 0, "L'élément n'est pas présent");
    }

    /**
     * Vérifie le texte d'un élément dans la page.
     *
     * @param driver le pilote WebDriver
     * @param locator le locator de l'élément à vérifier
     * @param expectedText le texte attendu
     */
    public static void assertElementText(WebDriver driver, By locator, String expectedText) {
        WebElement element = driver.findElement(locator);
        String actualText = element.getText().trim();
        Assert.assertEquals(actualText, expectedText, "Le texte de l'élément est incorrect");
    }

    /**
     * Vérifie la visibilité d'un élément dans la page.
     *
     * @param driver le pilote WebDriver
     * @param locator le locator de l'élément à vérifier
     */
    public static void assertElementVisible(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        Assert.assertTrue(element.isDisplayed(), "L'élément n'est pas visible");
    }

    /**
     * Vérifie l'égalité de la valeur d'un attribut d'un élément dans la page.
     *
     * @param driver le pilote WebDriver
     * @param locator le locator de l'élément à vérifier
     * @param attribute le nom de l'attribut à vérifier
     * @param expectedValue la valeur attendue de l'attribut
     */
    public static void assertAttributeEquals(WebDriver driver, By locator, String attribute, String expectedValue) {
        WebElement element = driver.findElement(locator);
        String actualValue = element.getAttribute(attribute);
        Assert.assertEquals(actualValue, expectedValue, "La valeur de l'attribut est incorrecte");
    }

    /**


    /**
     * Vérifie la présence d'un texte dans la page affichée par le WebDriver.
     *
     * @param driver le pilote WebDriver
     * @param expectedText le texte attendu
     */
    public static void assertTextPresent(WebDriver driver, String expectedText) {
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains(expectedText), "Le texte n'est pas présent sur la page");
    }
}



