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

public class PaymentPage {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(PaymentPage.class);
	
	
	public PaymentPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WaitHelper waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(paymentText, ObjectReader.reader.getExplicitWait());
		new TestBase().getNavigationScreen(driver);
		log.info("Summary Page initialised");
	}
	
	@FindBy(xpath = "//h1[contains(text(),'Please choose your payment method')]")
	public WebElement paymentText;
	
	@FindBy(xpath="//a[@class='bankwire']")
	public WebElement payByBankWire;
	
	@FindBy(xpath="//a[@class='cheque']")
	public WebElement payByCheque;
	
	
	
	public void selectPayByBankWire()
	{
		new JavascriptHelper(driver).scrollIntoView(payByBankWire);
		ObjectReader.reader.getImplicitWait();
	payByBankWire.click();
	log.info(" Selecting payment by bankwire");
	TestBase.logExtendReport("Selecting payment by bankwire");
	}
	
	public void selectPayByCheque()
	{
		new JavascriptHelper(driver).scrollIntoView(payByCheque);
		ObjectReader.reader.getImplicitWait();
		payByCheque.click();
		log.info(" Selecting payment by cheque");
		TestBase.logExtendReport("Selecting payment by cheque");
	}
	
	
	
	
	
	
	
	
	

}
