package com.global.automation.ui.listener;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 *
 */
public class Listeners implements ITestListener {

    private static final Logger LOGGER = LogManager.getLogger(Listeners.class);
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
