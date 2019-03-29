package com.uiFrameworkNew.companyName.projectName.helperClasses;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificationHelper
{
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(VerificationHelper.class);
	public VerificationHelper(WebDriver driver)
	{
		this.driver = driver;
		
	}
	
	public boolean isDisplayed(WebElement element)
	{
		try{
			element.isDisplayed();
			log.info("Element displayed is : "+element.getText());
			return true;
		}
		catch(Exception e)
		{
			log.error("Element is not displayed "+e.getCause());
			return false;
		}
		
	}
	
	public boolean isNotDisplayed(WebElement element)
	{
		try{
			element.isDisplayed();
			log.info("Element displayed is : "+element.getText());
			return false;
		}
		catch(Exception e)
		{
			log.error("Element is not displayed "+e.getCause());
			return true;
		}
		
	}
	public String getText(WebElement element)
	{
		if(null==element)
		{
			log.info("WebElement is null");
			return null;
		}
		boolean status = isDisplayed(element);
		if(status)
		{
			log.info("element text is..." +element.getText());
			return(element.getText());
		}
		else
		{
			return null;
		}
	}
	
	public String readValueFromElement(WebElement element)
	{
		if(null==element)
		{
			log.info("WebElement is null");
			return null;
		}
		boolean status = isDisplayed(element);
		if(status)
		{
			log.info("element text is..." +element.getText());
			return(element.getText());
		}
		else
		{
			return null;
		}
	}
	
	public String getTitle()
	{
		log.info("Title of page is "+driver.getTitle());
		return driver.getTitle();
	}
}