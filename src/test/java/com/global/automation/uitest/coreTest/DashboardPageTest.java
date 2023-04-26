package com.global.automation.uitest.coreTest;

import com.global.automation.base.BaseTest;
import com.global.automation.model.business.pageobject.Dashboard;
import com.global.automation.model.business.pageobject.DemoDashboard;
import com.global.automation.model.business.pageobject.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class DashboardPageTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(DashboardPageTest.class);
    public LoginPage loginPage;
    public Dashboard dashboard;
    public DemoDashboard demoDashboard;

    @Parameters({"username","password"})
    @Test
    public void loginToReportPortal(String username, String pwd) {
        dashboard = new Dashboard(driver);
        loginPage = new LoginPage(driver);
        demoDashboard = new DemoDashboard(driver);
        loginPage.enterLoginName(username);
        loginPage.enterLoginPwd(pwd);
        loginPage.clickOnLogin();
        dashboard.clickOnDemoDashboard();

    }

    @Test(dependsOnMethods = "loginToReportPortal")
    public void totalWidgetPresent(){

        demoDashboard.getTotalWidgetPresetOnDemoDashboard();
        Assert.assertEquals(demoDashboard.getTotalWidgetPresetOnDemoDashboard(), 12);
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
    public void search(String keyWord){
        boolean isPresent = demoDashboard.verifyNamesOfWidgetPresetOnDemoDashboard(keyWord);
        Assert.assertTrue(isPresent);
    }
}
