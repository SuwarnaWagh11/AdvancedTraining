package com.global.automation.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    protected static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
    public static WebDriver driver;
    public Properties properties;

    public Properties readPropFile() throws IOException {
        FileReader read = new FileReader("C:\\AdvancedTraining\\src\\test\\resources\\config.properties");
        properties = new Properties();
        properties.load(read);
        LOGGER.info("Property files loaded successfully**********");
        return properties;
    }

    @BeforeTest
    public void setUpTests() throws IOException {
        properties = readPropFile();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get(properties.getProperty("url"));
        driver.manage().window().fullscreen();
        LOGGER.info("Test set up done successfully**********");
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
        LOGGER.info("Test executed**********");
    }
}
