package com.tmb.listeners;

import com.tmb.reports.ExtentLogger;
import com.tmb.reports.ExtentReport;
import org.testng.*;
//6.14.3 -->
public class ListenersClass implements ITestListener, ISuiteListener {
    @Override //before method
    public void onTestStart(ITestResult result) {
        ExtentReport.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getName() + " is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("On test failure");
        ExtentLogger.fail(result.getName() + " is failed miserably");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getName() + " is skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    //dont have to provide any implementation
    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

    @Override //BeforeSuite
    public void onStart(ISuite suite) {
        ExtentReport.initReports();//create
    }

    @Override //AfterSuite
    public void onFinish(ISuite suite) {

        ExtentReport.tearDownReports();
    }
}
