package com.w2a.listeners;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.TestBase;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static com.w2a.utilities.TestUtil.captureScreenshot;

public class CustomListeners extends TestBase implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {

        test = rep.startTest(iTestResult.getName().toUpperCase());
    }

    public void onTestSuccess(ITestResult iTestResult) {

        test.log(LogStatus.PASS,iTestResult.getName().toUpperCase() + " PASS");
        rep.endTest(test);
        rep.flush();
    }

    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() + " HAS FAILED!!!");
        try {
            captureScreenshot(result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        test.log(LogStatus.FAIL,result.getName().toUpperCase() + " Failed with exception : " + result.getThrowable());
        rep.endTest(test);
        rep.flush();
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
