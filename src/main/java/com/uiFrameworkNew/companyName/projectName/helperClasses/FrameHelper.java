package com.uiFrameworkNew.companyName.projectName.helperClasses;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHelper {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(FrameHelper.class);
	
	public FrameHelper(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * This method will switch to frame based on frame index
	 * @param index
	 */
	public void switchToFrame(int index)
	{
		driver.switchTo().frame(index);
		log.info("Switched to "+index+ " frame");
		
	}
	
	/**
	 * This method will switch to frame based on frame frameName
	 * @param frameName
	 */
	
	public void switchToFrame(String frameName)
	{
		driver.switchTo().frame(frameName);
		log.info("Switched to "+frameName+ " frame");
		
	}
	
	/**
	 * This method will switch to frame based on WebElement
	 * @param element
	 */
	
	public void switchToFrame(WebElement element)
	{
		driver.switchTo().frame(element);
		log.info("Switched to frame");
		
	}
	
	
	
	
	
	

}
