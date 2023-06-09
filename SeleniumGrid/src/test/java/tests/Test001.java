package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Test001 {

    @Test
    public void loginToReportPortalChrome() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
/*        caps.setCapability("","");
        caps.setCapability("","");
        caps.setCapability("","");
        caps.setCapability("","");
        caps.setCapability("","");*/
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.11:4444"), caps);
        driver.get("http://localhost:8080/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.name("login")).sendKeys("superadmin");
        driver.findElement(By.name("password")).sendKeys("erebus");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Assert.assertEquals(driver.getTitle(), "Report Portal", "asserting the title of the page");
        driver.quit();
    }
}
