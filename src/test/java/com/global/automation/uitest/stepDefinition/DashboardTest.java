package com.global.automation.uitest.stepDefinition;

import com.global.automation.ui.model.business.pageobject.Dashboard;
import com.global.automation.ui.model.business.pageobject.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DashboardTest {

    private static final Logger LOGGER = LogManager.getLogger(DashboardTest.class);
    public WebDriver driver;
    public Dashboard dashboard;
    public LoginPage loginPage;
    @Given("user launch the chrome browser")
    public void user_launch_the_chrome_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        dashboard = new Dashboard(driver);
        loginPage = new LoginPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @When("User opens the URL {string}")
    public void user_opens_the_url(String url) {
        driver.get(url);
        //Thread.sleep(1000);
    }

    @When("Log in to the report portal with user {string} and password {string}")
    public void log_in_to_the_report_portal_with_user_and_password(String username, String pwd) {
        loginPage.enterLoginName(username);
        loginPage.enterLoginPwd(pwd);
        loginPage.clickOnLogin();
        //Thread.sleep(1000);

        dashboard.clickOnDemoDashboard();
        //Thread.sleep(1000);
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
