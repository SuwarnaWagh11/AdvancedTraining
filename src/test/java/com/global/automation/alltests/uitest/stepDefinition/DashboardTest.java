package com.global.automation.alltests.uitest.stepDefinition;

import com.global.automation.model.business.pageobject.Dashboard;
import com.global.automation.model.business.pageobject.DemoDashboard;
import com.global.automation.model.business.pageobject.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class DashboardTest {

    private static final Logger LOGGER = LogManager.getLogger(DashboardTest.class);
    public WebDriver driver;
    public LoginPage loginPage;
    public Dashboard dashboard;
    private DemoDashboard demoDashboard;

    @Given("user launch the chrome browser")
    public void user_launch_the_chrome_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        dashboard = new Dashboard(driver);
        loginPage = new LoginPage(driver);
        demoDashboard = new DemoDashboard(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
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
    }
    @Then("Page title should be {string}")
    public void page_title_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Then("User clicks on DemoDashboard and get the total widget present in the dashboard page")
    public void user_clicks_on_demo_dashboard_and_get_the_total_widget_present_in_the_dashboard_page() {
        LOGGER.info("~~~~~~~~~~~~I am checking total widget~~~~~~~~~~~~~~");
        dashboard.clickOnDemoDashboard();
        Assert.assertEquals(demoDashboard.getTotalWidgetPresetOnDemoDashboard(), 12);
    }

    @Then("Verify that DemoDashboard page contains {string}")
    public void verify_that_demo_dashboard_page_contains(String keyWord) {
        boolean isPresent = demoDashboard.verifyNamesOfWidgetPresetOnDemoDashboard(keyWord);
        Assert.assertTrue(isPresent);
    }
    @Then("Verify that widget contains total item")
    public void verify_that_widget_contains_total_item() {

        demoDashboard.verifyStatisticsExecutionTotalItemIsPresent();
    }
    @Then("User closes the browser")
    public void User_closes_the_browser() {
        driver.quit();
    }
}
