package com.uiFrameworkNew.companyName.projectName.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiFrameworkNew.companyName.projectName.helper.browserConfigurations.ObjectReader;
import com.uiFrameworkNew.companyName.projectName.helperClasses.JavascriptHelper;
import com.uiFrameworkNew.companyName.projectName.helperClasses.LoggerHelper;
import com.uiFrameworkNew.companyName.projectName.helperClasses.WaitHelper;
import com.uiFrameworkNew.companyName.projectName.testBase.TestBase;

public class ShippingPage {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(ShippingPage.class);
	
	public ShippingPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WaitHelper waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(shippingTitle, ObjectReader.reader.getExplicitWait());
		new TestBase().getNavigationScreen(driver);
		log.info("Summary Page initialised");
	}
	
	@FindBy(xpath="//button[@name='processCarrier']")
	public WebElement procceedShipping;
	
	@FindBy(xpath="//h1[contains(text(),'Shipping')]")
	public WebElement shippingTitle;
	
	@FindBy(xpath="//input[@name='cgv']")
	public WebElement termsCheckBox;
	
	public void checkTermsAndConditions()
	{
		new JavascriptHelper(driver).scrollIntoView(termsCheckBox);
		ObjectReader.reader.getImplicitWait();
		termsCheckBox.click();
		log.info("terms and conditions checked");
		TestBase.logExtendReport("terms and conditions checked");
	}
	
	public void clickOnProceedShippingPage()
	{
		new JavascriptHelper(driver).scrollIntoView(procceedShipping);
		ObjectReader.reader.getImplicitWait();
		procceedShipping.click();
		log.info("Proceed to checkout clicked in shipping page");
		TestBase.logExtendReport("Proceed to checkout clicked in shipping page");
	}
	
	
}
