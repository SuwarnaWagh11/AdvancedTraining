package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./features",
                glue = "stepDefinitions",
                dryRun = false,
                //tags = "@Test11 or @Test12",
                monochrome = true,
                plugin = {"pretty","html:target/cucumber-reports/MyHtmlReport.html",
                        "json:target/cucumber-reports/cucumber-json.json",
                        "junit:target/cucumber-reports/cucumber-junit.xml"},
                publish = true)

public class TestRunner {
}
