package com.uiFrameworkNew.companyName.projectName.testBase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.uiFrameworkNew.companyName.projectName.helper.browserConfigurations.BrowserType;
import com.uiFrameworkNew.companyName.projectName.helper.browserConfigurations.ChromeBrowser;
import com.uiFrameworkNew.companyName.projectName.helper.browserConfigurations.FirefoxBrowser;
import com.uiFrameworkNew.companyName.projectName.helper.browserConfigurations.InternetExplorerBrowser;
import com.uiFrameworkNew.companyName.projectName.helper.browserConfigurations.ObjectReader;
import com.uiFrameworkNew.companyName.projectName.helper.browserConfigurations.PropertyReader;
import com.uiFrameworkNew.companyName.projectName.helperClasses.ExtentManager;
import com.uiFrameworkNew.companyName.projectName.helperClasses.LoggerHelper;
import com.uiFrameworkNew.companyName.projectName.helperClasses.ResourceHelper;
import com.uiFrameworkNew.companyName.projectName.helperClasses.WaitHelper;

public class TestBase {
	
	public static ExtentReports extent;
	public static ExtentTest test; 
	public WebDriver driver;
	public static File reportDirectory;
	
	public Logger log = LoggerHelper.getLogger(TestBase.class);
	
	@BeforeSuite
	public void beforeSuite()
	{
		extent = ExtentManager.getInstance();
	}
	@BeforeTest
	public void beforeTest()
	{
		reportDirectory = new File(ResourceHelper.getResoucePath("src/main/resources/ScreenShots"));
		ObjectReader.reader = new PropertyReader();
		setUpDriver(ObjectReader.reader.getBrowserType());
		
		
	}
	@BeforeClass
	public void beforeClass()
	{
		test = extent.createTest(getClass().getName());
	}
	
	@BeforeMethod
	public void beforeMethod(Method method)
	{
		test.log(Status.INFO, method.getName()+" test started");
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL,result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName()+" test is pass");
		}
		else if(result.getStatus() == ITestResult.SKIP)
		{
			test.log(Status.SKIP, result.getThrowable());
		}
	extent.flush();

	}
	
	public WebDriver getBrowserObject(BrowserType bType)
	{
		try
		{
			switch(bType)
			{
			case Chrome:
				ChromeBrowser chrome = new ChromeBrowser();
				return chrome.getChromeDriver(chrome.getChromeOptions());
			case Firefox:
				FirefoxBrowser firefox = new FirefoxBrowser();
				return firefox.getFirefoxDriver(firefox.getFirefoxOptions());
			case Iexplorer:
				InternetExplorerBrowser iexplorer = new InternetExplorerBrowser();
				return iexplorer.getInternetexplorerDriver(iexplorer.getIEOptions());
				default:
					throw new Exception("driver not found "+bType.name());
									
			}
			
		}
		catch(Exception e)
		{
			log.info(e.getMessage());
		}
		return null;
	}
	
	
	public void setUpDriver(BrowserType bType)
	{
		driver = getBrowserObject(bType);
		log.info("initialize web driver "+ driver.hashCode());
		WaitHelper wait = new WaitHelper(driver);
		wait.setImplicitWait(ObjectReader.reader.getImplicitWait(), TimeUnit.SECONDS);
		wait.pageLoadTime(ObjectReader.reader.getPageLoadTime(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public String captureScreen(String fileName, WebDriver driver)
	{
		if(driver==null)
		{
			log.info("driver is null");
			return null;
		}
		if(fileName=="")
		{
			fileName="blank";
			
		}
		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File srceFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			destFile = new File(reportDirectory+"/"+fileName+"_"+formater.format(calendar.getTime())+".png");
			Files.copy(srceFile.toPath(),destFile.toPath());
			Reporter.log("<a href='"+destFile.getAbsolutePath()+"'><img src='"+destFile.getAbsolutePath()+"'height='100' width='100'></a>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}
		return destFile.toString();
		
	}
	
	public void getNavigationScreen(WebDriver driver)
	{
		log.info("capturing the navigation screen");
		String screen = captureScreen("",driver);
		try
		{
			test.addScreencastFromPath(screen);
		}catch(IOException e)
		{
			e.printStackTrace();
			
		}
	}
	
	public static void logExtendReport(String s1)
	{
		test.log(Status.INFO,s1);
		
	}
	
	public void getApplicationURL(String url)
	{
		driver.get(url);
		log.info("Url is opened");
		TestBase.logExtendReport("Url is opened");
	}
	

}
