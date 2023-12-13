package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import library.FunctionsLogger;
import library.FunctionsSelenium;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.testng.annotations.BeforeTest;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@AMAZON_CONNEXION or @PAIEMENT_AMAZON or @COMMANDE_AMAZON",
        plugin = {
                "pretty",
                "json:target/cucumber.json",
                "html:target/cucumber"
        },
        features = "src/test/resources/features/",
        glue = {"src/main/java", "step_definition"},
        monochrome = true
)
public class RunScenarioAmazon {
        @BeforeTest
        public void before() {
                new FunctionsLogger("test-output/logs/log");
        }
}
