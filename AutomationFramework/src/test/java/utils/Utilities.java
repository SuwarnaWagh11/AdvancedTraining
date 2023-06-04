package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

public class Utilities {

    public static String takeScreenshotUtil(WebDriver driver){
        String path;
        try {
            WebDriver augmentedDriver = new Augmenter().augment(driver);
            File source = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
            path = "./target/screenshots/" + source.getName();
            FileUtils.copyFile(source, new File(path));
        }
        catch(IOException e) {
            path = "Failed to capture screenshot: " + e.getMessage();
        }
        return path;
    }

    public void setWebdriverWait(WebDriver driver, Duration timeoutInSeconds, By by){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void setFluentWait(WebDriver driver, Duration timeoutDuration, Duration pollingDuration,By by){

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(timeoutDuration)
                .pollingEvery(pollingDuration)
                .ignoring(NoSuchElementException.class);

        WebElement aboutMe= wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
    }
}
