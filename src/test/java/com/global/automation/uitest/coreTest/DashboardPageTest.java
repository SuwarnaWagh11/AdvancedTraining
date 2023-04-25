package com.global.automation.uitest.coreTest;

import com.global.automation.base.BaseTest;
import com.global.automation.model.business.pageobject.Dashboard;
import com.global.automation.model.business.pageobject.LoginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class DashboardPageTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(DashboardPageTest.class);
    public LoginPage loginPage;
    public Dashboard dashboard;

    @Parameters({"username","password"})
    @Test
    public void loginToReportPortal(String username, String pwd) throws IOException {
        dashboard = new Dashboard(driver);
        loginPage = new LoginPage(driver);
        loginPage.enterLoginName(username);
        loginPage.enterLoginPwd(pwd);
        loginPage.clickOnLogin();
        dashboard.clickOnDemoDashboard();
    }
}
