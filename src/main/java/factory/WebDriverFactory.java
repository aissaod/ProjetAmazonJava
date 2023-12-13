package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Dictionary;

public class WebDriverFactory {

    public static WebDriver driver;

    public void setupBrowser(String browser, String url) {
        String currDir = System.getProperty("user.dir");
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", currDir + "\\driver\\chromedriver.exe");
            driver = new ChromeDriver();
        } else {
            System.out.println("valid browser was not provided");
            System.exit(0);
        }
        if (url != "")
            driver.get(url);
        else
            driver.get("about:blank");
    }

    public void quit() {
        driver.quit();
    }
}

