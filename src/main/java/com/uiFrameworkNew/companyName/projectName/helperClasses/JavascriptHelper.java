package com.uiFrameworkNew.companyName.projectName.helperClasses;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptHelper {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(JavascriptHelper.class);
	
	public JavascriptHelper(WebDriver driver)
	{
		this.driver = driver;
		log.info("Javascript helper has been initialised");
	}
	
	/**
	 * This method will execute the script
	 * @param script
	 * @return
	 */
	public Object executeScript(String script)
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script);
	}
	/**
	 * This method will execute the script with multiple arguments
	 * @param script
	 * @return
	 */
	public Object executeScript(String script, Object...args)
	{
		JavascriptExecutor exe = (JavascriptExecutor)driver;
		return exe.executeScript(script, args);
		
	}

	/**
	 * This method will scroll To element based on the web element
	 * @param element
	 */
	public void scrollToElement(WebElement element)
	{
		log.info("Scrolling to webelement "+element);
		executeScript("window.scrollTo(arguments[0],arguments[1])",element.getLocation().x,element.getLocation().y);
	}
	/**
	 * This method will scroll To element based on the web element and click it
	 * @param element
	 */
	public void scrollToElementAndClick(WebElement element)
	{
		log.info("Scroll to elemenet and clicked");
		scrollToElement(element);
		element.click();
	}
	/**
	 * This method will scroll To element based on the web element
	 * @param element
	 */
	public void scrollIntoView(WebElement element)
	{
		log.info("Scrolling into element "+element);
		executeScript("arguments[0].scrollIntoView()",element);
		
	}
	/**
	 * This method will scroll To element based on the web element and click it
	 * @param element
	 */
	public void scrollIntoViewAndClick(WebElement element)
	{
		log.info("Scrolling into element and clicking"+element);
		scrollIntoView(element);
		element.click();
		
	}
	/**
	 * This method will scroll down vertically
	 * @param pixel
	 */
	public void scrollDownVertically()
	{
		log.info("Scrolling down vertically");
		executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	/**
	 * This method will scroll up vertically
	 * @param pixel
	 */
	public void scrollUpVertically()
	{
		log.info("Scrolling up vertically");
		executeScript("window.scrollTo(0,-document.body.scrollHeight)");
	}
	/**
	 * This method will scroll down to pixel location
	 * @param pixel
	 */
	public void scrollDownByPixel(int pixel)
	{
		log.info("Scrolling down to pixel location " +pixel);
		executeScript("window.scrollTo(0,"+pixel+")");
	}
	/**
	 * This method will scroll up to pixel location
	 * @param pixel
	 */
	
	public void scrollUpByPixel(int pixel)
	{
		log.info("Scrolling up to pixel location " +pixel);
		executeScript("window.scrollTo(0,-"+pixel+")");
	}
	/**
	 * this method will zoom by 100%
	 */
	public void zoomInBy100Percentage()
	{
		log.info("zooming in by 100%");
		executeScript("document.body.style.zoom='100%'");
	}
	/**
	 * this method will zoom by 60%
	 */
	public void zoomInBy60Percentage()
	{
		log.info("zooming in by 60%");
		executeScript("document.body.style.zoom='60%'");
	}
	/**
	 * This method will click on the element
	 * @param element
	 */
	public void clickOnElement(WebElement element)
	{
		log.info("clicking on element "+element);
		executeScript("arguments[0].click()",element);
	}
}
