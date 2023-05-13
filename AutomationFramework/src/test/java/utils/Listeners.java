package utils;


import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 *
 */
public class Listeners implements ITestListener, IAnnotationTransformer {

    private static final Logger LOGGER = LogManager.getLogger(Listeners.class);

    //@Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyser.class);
    }
    @Override
    public void onTestStart(ITestResult result) {
        LOGGER.info("Started Test "+ result.getTestName());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        LOGGER.info("Succeeded Test "+ result.getTestName());
    }
    @Override
    public void onTestFailure(ITestResult result) {
        LOGGER.info("Failed Test "+ result.getTestName());
       /* String fileName = System.getProperty("user.dir")+ File.separator + "screenshot" + File.separator + result.getMethod().getMethodName();
        File file = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(file, new File(fileName+".png"));
            BaseTest.logger1.addScreenCaptureFromPath("fileName");
        }catch(IOException e){
            e.printStackTrace();
        }*/

    }
    @Override
    public void onTestSkipped(ITestResult result) {
        LOGGER.info("Skipped test "+ result.getTestName());
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        LOGGER.info("Test failed within success %  "+ result.getTestName());
    }
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }
    @Override
    public void onStart(ITestContext context) {
        LOGGER.info("Started "+ context.getName());
    }
    @Override
    public void onFinish(ITestContext context) {
        LOGGER.info("Finished "+ context.getName());
    }

}
