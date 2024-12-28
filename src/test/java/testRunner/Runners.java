package testRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
            features = {"src/test/java/org/GeneralStore/features"},
            glue = {"steps"},
            plugin = {"pretty" , "html:target/site/cucumber-pretty.html" , "json:target/cucumber.json"}
    )

    public class Runners {
    }


