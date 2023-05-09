package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/*import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;*/

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    protected static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
    public static WebDriver driver;
    public Properties properties;
    public ExtentHtmlReporter htmlReporter;
    public static ExtentReports extentReports;
    public static ExtentTest logger1;
    @Before
    public void beforeTesst(){
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+ File.separator + "reportss" + File.separator + "BDDAutomationExtentReport.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("");
        htmlReporter.config().setTheme(Theme.DARK);
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("Automation Tester","Suwarna Wagh");
    }
    @Before
    public void beforeMethod(Method method) throws IOException {
        logger1 = extentReports.createTest(method.getName());
        setUpDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.manage().window().maximize();
        driver.get(properties.getProperty("url"));
    }
    @After
    public void afterMethodd(){
/*        if(result.getStatus()==ITestResult.SUCCESS){
            String logText = "Test Case: "+result.getMethod().getMethodName()+"  Passed";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            logger1.log(Status.PASS, markup);
        } else if (result.getStatus()==ITestResult.FAILURE) {
            String logText = "Test Case: "+result.getMethod().getMethodName()+"  Failed";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.RED);
            logger1.log(Status.FAIL, markup);
        } else if (result.getStatus()==ITestResult.SKIP) {
            String logText = "Test Case: "+result.getMethod().getMethodName()+"  Skipped";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREY);
            logger1.log(Status.SKIP, markup);
        }*/
        logger1.info("***Closing the Chrome Driver***");
        driver.quit();
        LOGGER.info("Test executed**********");
    }
    public void setUpDriver() throws IOException {
        logger1.info("***Setting up Chrome Driver***");
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
        LOGGER.info("Test driver set up done successfully**********");
    }
    public Properties readPropFile() throws IOException {
        logger1.info("***Reading the property file***");
        FileReader read = new FileReader("C:\\AdvancedTraining\\src\\test\\resources\\config.properties");
        properties = new Properties();
        properties.load(read);
        LOGGER.info("Property files loaded successfully**********");
        return properties;
    }
    @After
    public void tearDown() {
        extentReports.flush();
    }
}
