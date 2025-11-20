package runner;



import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/featureFiles", // Path to your feature files
        glue = "com.qa.makeMyrTrip.Steps", // Package where your step definitions are located
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-html-report.html", "json:target/cucumber-reports/cucumber.json"
        ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, // Reporting options
        tags = "@Demo", // Optional: Run only scenarios tagged with @SmokeTest
        monochrome = true,
        dryRun=false
        )

public class Runner {

}
