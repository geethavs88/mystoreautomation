package com.uiFrameworkNew.companyName.projectName.helperClasses;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AssertionHelper {

	private WebDriver driver;
	private static Logger log = LoggerHelper.getLogger(AssertionHelper.class);
	
	public AssertionHelper(WebDriver driver)
	{
		this.driver = driver;
	}
	public static void verifyText(String s1, String s2)
	{
		log.info("Verifying the strings are equal?");
		Assert.assertEquals(s1, s2);
		
	}
	public static void makeTrue()
	{
		log.info("Making the script pass");
		Assert.assertTrue(true);
		
	}
	public static void makeTrue(String message)
	{
		log.info("Making the script pass");
		Assert.assertTrue(true,message);
		
	}
	public static void makeFalse()
	{
		log.info("Making the script fail");
		Assert.assertTrue(false);
		
	}
	public static void makeFalse(String message)
	{
		log.info("Making the script fail");
		Assert.assertTrue(false,message);
		
	}
	public static void verifyTrue(boolean status)
	{
		log.info("Verifying the status to be true");
		Assert.assertTrue(status);
	}
	public static void verifyFalse(boolean status)
	{
		log.info("Verifying the status to be false");
		Assert.assertFalse(status);
	}
	public static void verifyNull(String s1)
	{
		log.info("Verifying the object is null");
		Assert.assertNull(s1);
	}
	public static void verifyNotNull(String s1)
	{
		log.info("Verifying the object is not null");
		Assert.assertNotNull(s1);
	}
	public static void verifyTestStatus(boolean status)
	{
		if(status) {
			makeTrue();
		}
		else
			makeFalse();
	}
}
