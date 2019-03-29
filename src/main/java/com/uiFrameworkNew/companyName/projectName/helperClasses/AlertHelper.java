package com.uiFrameworkNew.companyName.projectName.helperClasses;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class AlertHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(AlertHelper.class);
	
	public AlertHelper(WebDriver driver)
	{
		this.driver = driver;
	}
	/**
	 * This method will switch to an alert
	 * @return
	 */
	public Alert getAlert()
	{
		log.info("switching to alert "+driver.switchTo().alert().getText());
		return driver.switchTo().alert();
	}
	/**
	 * This method will accept the alert
	 */
	public void acceptAlert()
	{
		log.info("Accepting the alert");
		getAlert().accept();
	}
	/**
	 * This method will dismiss the alert
	 */

	public void dismissAlert()
	{
		log.info("Dismissing the alert");
		getAlert().dismiss();
	}
	/**
	 * Return the alert text
	 * @return
	 */
	public String getAlertText()
	{
		String text = getAlert().getText();
		log.info("Returning the alert text "+text);
		return text;
	}
	/**
	 * Check if alert is present 
	 * @return
	 */
	
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			log.info("alert is present");
			return true;
		}
		catch(NoAlertPresentException e)
		{
			log.info(e.getCause());
			return false;
		}
		
	}
	/**
	 * Accept alert if it is present
	 */
	public void acceptAlertIfPresent()
	{
		if(isAlertPresent())
		{
			acceptAlert();
		}
		else
		{
			log.info("alert is not present");
		}
	}
	/**
	 *dismiss the alert if present 
	 */
	public void dismissAlertIfPresent()
	{
		if(isAlertPresent())
		{
			dismissAlert();
		}
		else
		{
			log.info("alert is not present");
		}
	}
	/**
	 * accept alert after entering the text
	 * @param text
	 */
	public void acceptPrompt(String text)
	{
		if(isAlertPresent())
		{
			Alert alert = getAlert();
			alert.sendKeys(text);
			alert.accept();
			log.info("alert text "+text);
		}
	}
	
}
