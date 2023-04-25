package com.global.automation.uitest.stepDefinition;

import com.global.automation.base.BaseTest;
import com.global.automation.model.business.pageobject.Dashboard;
import com.global.automation.model.business.pageobject.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;

public class DashboardTest {

    private static final Logger LOGGER = LogManager.getLogger(DashboardTest.class);
    public WebDriver driver;
    public LoginPage loginPage;
    public Dashboard dashboard;

    @Given("user launch the chrome browser")
    public void user_launch_the_chrome_browser() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        dashboard = new Dashboard(driver);
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @When("User opens the URL {string}")
    public void user_opens_the_url(String url) {
        driver.get(url);
    }

    @When("Log in to the report portal with user {string} and password {string}")
    public void log_in_to_the_report_portal_with_user_and_password(String username, String pwd) {
        loginPage.enterLoginName(username);
        loginPage.enterLoginPwd(pwd);
        loginPage.clickOnLogin();
        dashboard.clickOnDemoDashboard();
    }
    @Then("Page title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Then("User closes the browser")
    public void User_closes_the_browser() {
        driver.quit();
    }
}
