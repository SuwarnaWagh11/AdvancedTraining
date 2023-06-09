package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageobject.Dashboard;
import pageobject.DemoDashboard;
import pageobject.LoginPage;
import utils.UtilitiesClass;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    protected static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
    public static final String CONFIG_PROPERTIES = "C:\\AdvancedTraining\\AutomationFramework\\src\\test\\resources\\config.properties";
    public static WebDriver driver;
    public DesiredCapabilities caps;
    public Properties properties;
    public ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
    public LoginPage loginPage;
    public Dashboard dashboard;
    public DemoDashboard demoDashboard;
    public Actions actions;

    @BeforeTest
    public void setUpTest() throws IOException {
        setUpReport();
    }
    @Parameters({"browserName","user","password"})
    @BeforeMethod
    public void beforeMethod(String browserName,String user, String password) throws IOException {

        test = extent.createTest("BeforeMethod : ","Setting Up test");
        caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.BROWSER_NAME,browserName);
        driver = new RemoteWebDriver(new URL("http://192.168.1.11:4444"), caps);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.manage().window().maximize();
        properties = readPropFile();
        driver.get(properties.getProperty("url"));
        loginPage.enterLoginName(user);
        loginPage.enterLoginPwd(password);
        loginPage.clickOnLogin();
        LOGGER.info("Logged in");
    }
    @AfterMethod
    public void getTestResult(ITestResult result){
        if(result.getStatus()==ITestResult.SUCCESS){
            String logText = "Test Case: "+result.getMethod().getMethodName()+"  Passed";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            test.log(Status.PASS, markup);
        } else if (result.getStatus()==ITestResult.FAILURE) {
            String logText = "Test Case: "+result.getMethod().getMethodName()+"  Failed";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.RED);
            test.log(Status.FAIL, markup);
            UtilitiesClass.takeScreenshotUtil(driver);
        } else if (result.getStatus()==ITestResult.SKIP) {
            String logText = "Test Case: "+result.getMethod().getMethodName()+"  Skipped";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREY);
            test.log(Status.SKIP, markup);
        }
        driver.quit();
        LOGGER.info("Test executed**********");
    }
    @AfterTest
    public void tearDown() {
        extent.flush();
    }

    public void setUpReport() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ File.separator + "reports" + File.separator + "AutomationTestNGExtentReport.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester","Suwarna Wagh");
    }
    public Properties readPropFile() throws IOException {
        FileReader read = new FileReader(CONFIG_PROPERTIES);
        properties = new Properties();
        properties.load(read);
        setUpBeans();
        LOGGER.info("Property files loaded successfully**********");
        return properties;
    }
    public void setUpBeans(){
        actions = new Actions(driver);
        dashboard = new Dashboard(driver);
        loginPage = new LoginPage(driver);
        demoDashboard = new DemoDashboard(driver);
        actions = new Actions(driver);
    }
}
