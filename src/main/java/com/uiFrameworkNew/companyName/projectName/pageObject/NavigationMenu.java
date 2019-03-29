package com.uiFrameworkNew.companyName.projectName.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiFrameworkNew.companyName.projectName.helper.browserConfigurations.ObjectReader;
import com.uiFrameworkNew.companyName.projectName.helperClasses.LoggerHelper;
import com.uiFrameworkNew.companyName.projectName.helperClasses.WaitHelper;
import com.uiFrameworkNew.companyName.projectName.testBase.TestBase;

public class NavigationMenu {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(NavigationMenu.class);
	
	
	public NavigationMenu(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		log.info("Navigation menu initialised");
		TestBase.logExtendReport("Navigation menu initialised");
		WaitHelper waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(women, ObjectReader.reader.getExplicitWait());
		new TestBase().getNavigationScreen(driver);
				
	}

	@FindBy(xpath="//a[@title='Women']")
	public WebElement women;
	
	@FindBy(xpath="//a[@title='Dresses']")
	public WebElement dresses;
	
	@FindBy(xpath="//a[@title='T-shirts']")
	public WebElement tShirt;
	
	public void mouseOver(String data)
	{
		log.info("doing mouse over on : "+data);
		TestBase.logExtendReport("doing mouse over on : "+data);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'"+data+"')]"))).build().perform();
		
	}
	
	public ProductCategoryPage clickOnItem(String data)
	{
		log.info("Clicking on the item "+data);
		TestBase.logExtendReport("Clicking on the item "+data);
		driver.findElement(By.xpath("//*[contains(text(),'"+data+"')]")).click();
		return new ProductCategoryPage(driver);
	}
	
	public ProductCategoryPage clickOnMenu(WebElement element)
	{
		log.info("clicking on menu item "+element.getText());
		TestBase.logExtendReport("clicking on menu item "+element.getText());
		element.click();
	    return new ProductCategoryPage(driver);	
	}
	
	
	
}
