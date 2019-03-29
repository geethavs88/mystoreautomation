package com.uiFrameworkNew.companyName.projectName.helperClasses;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ExtentListener implements ITestListener {
	public static ExtentReports extent;
	public static ExtentTest test; 

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		test.log(Status.INFO, result.getName()+" Started..");
		Reporter.log(result.getMethod().getMethodName()+" Test started ");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, result.getName()+" Passed..");
		Reporter.log(result.getMethod().getMethodName()+" Test Passed ");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log(result.getMethod().getMethodName()+" Test failed " +result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(result.getMethod().getMethodName()+" Test skipped " +result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		extent = ExtentManager.getInstance();
		test = extent.createTest(context.getName());
		Reporter.log(context.getName()+" Test started");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log(context.getName()+" Test finished");
		extent.flush();
	}
	

}
