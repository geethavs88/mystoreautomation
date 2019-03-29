package com.uiFrameworkNew.companyName.projectName.pageObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiFrameworkNew.companyName.projectName.helper.browserConfigurations.ObjectReader;
import com.uiFrameworkNew.companyName.projectName.helperClasses.JavascriptHelper;
import com.uiFrameworkNew.companyName.projectName.helperClasses.LoggerHelper;
import com.uiFrameworkNew.companyName.projectName.helperClasses.WaitHelper;
import com.uiFrameworkNew.companyName.projectName.testBase.TestBase;

public class SummaryPage {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(SummaryPage.class);
	
	//@FindBy(xpath="//a[@title='Proceed to checkout']")
	@FindBy(xpath="//*[@id=\"center_column\"]/p[2]/a[1]")
	public WebElement proceedToCheckOut;
	
	@FindBy(xpath="//h1[@id='cart_title']")
	public WebElement cartTitle;
	
	
	
	@FindBy(xpath="//table[@id='cart_summary']/tbody/tr/td[2]/p/a")
	List<WebElement> elementNames;
	
	public SummaryPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WaitHelper waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(cartTitle, ObjectReader.reader.getExplicitWait());
		new TestBase().getNavigationScreen(driver);
		log.info("Summary Page initialised");
	}
	
	public void clickOnProceedToCheckout()
	{
		new WaitHelper(driver).setImplicitWait(10,TimeUnit.SECONDS);
		new JavascriptHelper(driver).scrollToElement(proceedToCheckOut);
new WaitHelper(driver).setImplicitWait(10,TimeUnit.SECONDS);
		proceedToCheckOut.click();
		log.info("clicking on proceed tgo checkout in summary page");
		TestBase.logExtendReport("clicking on proceed tgo checkout in summary page");
	}
	
	public void getListOfItems()
	{
		new JavascriptHelper(driver).scrollIntoView(elementNames.get(0));
		int rowsNumber = driver.findElements(By.xpath("//table[@id='cart_summary']/tbody/tr")).size();
		//List<WebElement> elementNames = driver.findElements(By.xpath("//table[@id='cart_summary']/tbody/tr]/td[2]/p/a"));
		
		ArrayList<String> itemNames = new ArrayList<String>();
		
		for(int i=0;i<rowsNumber;i++)
		{
			/*String fPart = "//table[@id='cart_summary']/tbody/tr[";
			String sPart = "]/td[2]/p/a" ;
		    String itemName = driver.findElement(By.xpath(fPart+i+sPart)).getText();
			 
			 itemNames.add(itemName);*/
			itemNames.add(elementNames.get(i).getText());
					 
		}
				
		//System.out.println(itemNames);
		log.info("item names are : "+itemNames);
		
		
	}
	

}
