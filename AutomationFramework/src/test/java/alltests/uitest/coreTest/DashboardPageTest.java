package alltests.uitest.coreTest;

import base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DashboardPageTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(DashboardPageTest.class);

    @Test
    public void totalWidgetPresent(){
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
        dashboard.clickOnDemoDashboard();
        boolean isPresent = demoDashboard.verifyNamesOfWidgetPresetOnDemoDashboard(keyWord);
        Assert.assertTrue(isPresent);
    }
}
