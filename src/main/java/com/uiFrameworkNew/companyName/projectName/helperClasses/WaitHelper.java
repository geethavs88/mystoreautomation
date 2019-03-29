package com.uiFrameworkNew.companyName.projectName.helperClasses;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WaitHelper.class);
	
	public WaitHelper(WebDriver driver)
	{
		this.driver = driver;
	}
	
	/**
	 * This is implicit wait 
	 * @param timeOut
	 * @param unit
	 */
	public void setImplicitWait(long timeOut, TimeUnit unit)
	{
		log.info("Implicit wait has been set to: "+timeOut);
		driver.manage().timeouts().implicitlyWait(timeOut, unit);
		
	}
	
	/**
	 * This method will get wait object
	 * @param timeOutInSeconds
	 * @param pollingInEveryMilliSeconds
	 * @return
	 */
	private WebDriverWait getWait(int timeOutInSeconds, int pollingInEveryMilliSeconds)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
		wait.pollingEvery(Duration.ofMillis(pollingInEveryMilliSeconds));
		wait.ignoring(NoSuchElementException.class);
		wait.ignoring(ElementNotVisibleException.class);
		wait.ignoring(StaleElementReferenceException.class);
		wait.ignoring(NoSuchFrameException.class);
		
		return wait;
	}
	/**
	 * This method will wait till element is visible
	 * @param element
	 * @param timeOutInSeconds
	 * @param pollingInEveryMilliSeconds
	 */
	public void waitForElementVisible(WebElement element, int timeOutInSeconds, int pollingInEveryMilliSeconds)
	{
		log.info("waiting for element "+element+ "for "+timeOutInSeconds+ "seconds");
		WebDriverWait wait = getWait(timeOutInSeconds,pollingInEveryMilliSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("element is visible now");
		
	}
	/**
	 * This method will make sure whether element is clickable
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForElementClickable(WebElement element, int timeOutInSeconds)
	{
		log.info("waiting for element "+element+ "for "+timeOutInSeconds+ "seconds");
		WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		log.info("element is clickable now");
		
	}
	
	/**
	 * This method will wait for element to be invisible
	 * @param element
	 * @param timeOutInSeconds
	 * @return
	 */
	public boolean waitForElementNotPresent(WebElement element, int timeOutInSeconds)
	{
		log.info("waiting for element "+element+ "for "+timeOutInSeconds+ "seconds");
		WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
		boolean status =wait.until(ExpectedConditions.invisibilityOf(element));
		log.info("element is invisible now");
		return status;
	}
	/**
	 * This method will wait for frame to be available and switch to it
	 * @param element
	 * @param timeOutInSeconds
	 */
	public void waitForFrameToBeAvailableAndSwitchToIt(WebElement element, int timeOutInSeconds)
	{
		log.info("waiting for element "+element+ "for "+timeOutInSeconds+ "seconds");
		WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
	    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
		log.info("frame is available and switched to it");
		
	}
	
	public void pageLoadTime(long timeOut,TimeUnit unit)
	{
		log.info("waiting for page to be loaded for "+timeOut+" seconds");
		driver.manage().timeouts().pageLoadTimeout(timeOut, unit);
		log.info("page is loaded");
		
	}
	
	
	public void waitForElement(WebElement element, int timeOutInSeconds)
	{
		log.info("waiting for element "+element+ "for "+timeOutInSeconds+ "seconds");
		WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		log.info("element is clickable now");
		
	}
}
