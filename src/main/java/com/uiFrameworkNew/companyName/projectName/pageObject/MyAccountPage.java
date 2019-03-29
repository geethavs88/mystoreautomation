package com.uiFrameworkNew.companyName.projectName.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.uiFrameworkNew.companyName.projectName.helper.browserConfigurations.ObjectReader;
import com.uiFrameworkNew.companyName.projectName.helperClasses.LoggerHelper;
import com.uiFrameworkNew.companyName.projectName.helperClasses.VerificationHelper;
import com.uiFrameworkNew.companyName.projectName.helperClasses.WaitHelper;
import com.uiFrameworkNew.companyName.projectName.testBase.TestBase;

public class MyAccountPage {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(MyAccountPage.class);
	
	public MyAccountPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		WaitHelper waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(orderHistory,ObjectReader.reader.getExplicitWait());
		
	}
	
	@FindBy(xpath="//h1[text()='My account']")
	WebElement myAccountText;
	
	@FindBy(xpath="//a[@title='Orders']")
	WebElement orderHistory;
	
	@FindBy(xpath="//a[@title='My wishlists']")
	WebElement myWishList;
	
	@FindBy(xpath="//p[contains(text(),'Welcome to your account. Here you can manage all of your personal information and orders.')]")
	WebElement displayMessage;
	
	@FindBy(xpath="//a[@title='Home']")
	WebElement homeButton;
	
	public void clickOnWishlist()
	{
		log.info("clicked on My WishList");
		logExtendReport("clicked on My WishList");
		myWishList.click();
		
		
	}
	
	
	public void logExtendReport(String s1)
	{
		TestBase.test.log(Status.INFO,s1);
		
	}
	
	public boolean verifyDisplayMessage()
	{
		return new VerificationHelper(driver).isDisplayed(displayMessage);
	}
	
	

}
