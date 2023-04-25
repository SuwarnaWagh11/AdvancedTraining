package com.global.automation.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature",
                glue = "com.global.automation.uitest.stepDefinition",
                dryRun = false,
                tags = "@RegTest",// or @SanityTest or @SmokeTest",
                monochrome = true,
                plugin = {"pretty","html:target/cucumber-reports/MyHtmlReport.html",
                        "json:target/cucumber-reports/cucumber-json.json",
                        "junit:target/cucumber-reports/cucumber-junit.xml"},
                publish = true)

public class TestRunner {
}
