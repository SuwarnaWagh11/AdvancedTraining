package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pageobject.Dashboard;
import pageobject.DemoDashboard;
import pageobject.LoginPage;
import utils.UtilitiesClass;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    protected static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
    public static final String CONFIG_PROPERTIES = "C:\\AdvancedTraining\\AutomationFramework\\src\\test\\resources\\config.properties";
    public static WebDriver driver;
    public Properties properties;
    public ExtentHtmlReporter htmlReporter;
    public static ExtentReports extentReports;
    public static ExtentTest logger1;
    public LoginPage loginPage;
    public Dashboard dashboard;
    public DemoDashboard demoDashboard;
    public Actions actions;
    private ThreadLocal<String> testName = new ThreadLocal<>();
    @BeforeTest
    public void setUpTest(){
        htmlReporter = new ExtentHtmlReporter("C:\\AdvancedTraining\\Target_Reports\\AutomationTestNGExtentReport.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setTheme(Theme.DARK);
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("Automation Tester","Suwarna Wagh");
    }
    @BeforeMethod
    public void beforeMethod(Method method, Object[] testData, ITestContext ctx) throws IOException {
        setUpDriver();
        setUpBeans();
        logInToPortal();
        if (testData.length > 0) {
            testName.set(method.getName() + "_" + testData[0]);
            ctx.setAttribute("testName", testName.get());
        } else
            ctx.setAttribute("testName", method.getName());
        logger1 = extentReports.createTest(ctx.getAttribute("testName").toString());
    }
    @AfterMethod
    public void getTestResult(ITestResult result){
        if(result.getStatus()==ITestResult.SUCCESS){
            String logText = "Test Case: "+result.getMethod().getMethodName()+"  Passed";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger1.log(Status.PASS, markup);
        } else if (result.getStatus()==ITestResult.FAILURE) {
            String logText = "Test Case: "+result.getMethod().getMethodName()+"  Failed";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger1.log(Status.FAIL, markup);
            UtilitiesClass.takeScreenshotUtil(driver);
        } else if (result.getStatus()==ITestResult.SKIP) {
            String logText = "Test Case: "+result.getMethod().getMethodName()+"  Skipped";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREY);
            logger1.log(Status.SKIP, markup);
        }
        driver.quit();
        LOGGER.info("Test executed**********");
    }
    @AfterTest
    public void tearDown() {
        extentReports.flush();
    }

    public void setUpDriver() throws IOException {
        properties = readPropFile();
        String browserName = properties.getProperty("browserName");
        WebDriverManager.chromedriver().setup();
        if(browserName.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
        LOGGER.info("Test driver set up done successfully**********");
    }
    public Properties readPropFile() throws IOException {
        FileReader read = new FileReader(CONFIG_PROPERTIES);
        properties = new Properties();
        properties.load(read);
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
    public void logInToPortal(){
        LOGGER.info("Logging in to portal");
        loginPage.enterLoginName(properties.getProperty("loginName"));
        loginPage.enterLoginPwd(properties.getProperty("password"));
        loginPage.clickOnLogin();
        LOGGER.info("Logged in");
    }
}
