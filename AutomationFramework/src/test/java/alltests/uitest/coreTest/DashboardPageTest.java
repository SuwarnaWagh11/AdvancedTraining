package alltests.uitest.coreTest;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobject.Dashboard;
import pageobject.DemoDashboard;
import pageobject.LoginPage;

public class DashboardPageTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(DashboardPageTest.class);
    public LoginPage loginPage;
    public Dashboard dashboard;
    public DemoDashboard demoDashboard;

    @Parameters({"username","password"})
    @Test
    public void loginToReportPortal(@Optional String username, @Optional String pwd) {
        dashboard = new Dashboard(driver);
        loginPage = new LoginPage(driver);
        demoDashboard = new DemoDashboard(driver);
        loginPage.enterLoginName("superadmin");
        loginPage.enterLoginPwd("erebus");
        loginPage.clickOnLogin();
        dashboard.clickOnDemoDashboard();
        BaseTest.logger1.info("Test for Log in to portal");
    }
    @Parameters({"username","password"})
    @Test//(dependsOnMethods = "loginToReportPortal")
    public void totalWidgetPresent(@Optional String username,@Optional String pwd){
        dashboard = new Dashboard(driver);
        loginPage = new LoginPage(driver);
        demoDashboard = new DemoDashboard(driver);
        loginPage.enterLoginName("superadmin");
        loginPage.enterLoginPwd("erebus");
        loginPage.clickOnLogin();
        dashboard.clickOnDemoDashboard();
        demoDashboard.getTotalWidgetPresetOnDemoDashboard();
        Assert.assertEquals(demoDashboard.getTotalWidgetPresetOnDemoDashboard(), 12);
        BaseTest.logger1.info("Test for verifying total Widget Present on the dashboard");
    }
    @DataProvider(name = "test-data")
    public Object[][] dataProvFunc(){
        return new Object[][]{
                {"LAUNCH STATISTICS AREA"},{"LAUNCH STATISTICS BAR"},{"INVESTIGATED PERCENTAGE OF LAUNCHES"},
                {"TEST CASES GROWTH TREND CHART"},{"OVERALL STATISTICS PANEL"},{"LAUNCHES DURATION CHART"},
                {"OVERALL STATISTICS DONUT"},{"FAILED CASES TREND CHART"},{"LAUNCH TABLE"},
                {"MOST FAILED TEST CASES"},{"PASSING RATE SUMMARY"},{"FLAKY TEST CASES"}
        };
    }

    @Test(dataProvider ="test-data")
    public void searchDashboardNameDP(String keyWord){
        BaseTest.logger1.info("Test for verifying the '"+keyWord+"' Of Widget Preset On Demo Dashboard.");
        dashboard = new Dashboard(driver);
        loginPage = new LoginPage(driver);
        demoDashboard = new DemoDashboard(driver);
        loginPage.enterLoginName("superadmin");
        loginPage.enterLoginPwd("erebus");
        loginPage.clickOnLogin();
        dashboard.clickOnDemoDashboard();
        boolean isPresent = demoDashboard.verifyNamesOfWidgetPresetOnDemoDashboard(keyWord);
        Assert.assertTrue(isPresent);
    }
}
