package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.function.Function;

import static base.BaseTest.driver;

public class UtilitiesClass {
    static Actions actions = new Actions(driver);

    public static void scrollToElement(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //get the height of the webpage and scroll to the end
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static String takeScreenshotUtil(WebDriver driver){
        String path;
        try {
            WebDriver augmentedDriver = new Augmenter().augment(driver);
            File source = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
            path = "./screenshot/" + source.getName() + LocalDate.now() + System.currentTimeMillis();
            FileUtils.copyFile(source, new File(path));
        }
        catch(IOException e) {
            path = "Failed to capture screenshot: " + e.getMessage();
        }
        return path;
    }

    public static void setWebdriverWait(WebDriver driver, Duration timeoutInSeconds, By by){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void setFluentWait(WebDriver driver, Duration timeoutDuration, Duration pollingDuration,By by){
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
