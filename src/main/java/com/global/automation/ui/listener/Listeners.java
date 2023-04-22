package com.global.automation.ui.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 *
 */
public class Listeners implements ITestListener {
    public void onTestStart(ITestResult result) {
        System.out.println("Started Test "+ result.getTestName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Succeeded test "+result.getTestName());
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Failed test "+result.getTestName());
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Skipped test "+result.getTestName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test failed within success % "+result.getTestName());
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
        System.out.println("Started "+ context.getName());
    }

    public void onFinish(ITestContext context) {
        System.out.println("Finished "+context.getName());
    }

}
