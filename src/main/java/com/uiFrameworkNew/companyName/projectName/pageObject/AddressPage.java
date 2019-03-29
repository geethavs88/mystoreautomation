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

public class AddressPage {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(AddressPage.class);
	
	@FindBy(xpath="//h1[contains(text(),'Addresses')]")
	public WebElement addressText;
	
	@FindBy(xpath = "//button[@name='processAddress']")
	WebElement proceedAddress;
	
	public AddressPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WaitHelper waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(addressText, ObjectReader.reader.getExplicitWait());
		new TestBase().getNavigationScreen(driver);
		log.info("Summary Page initialised");
	}
	
	
	public void clickOnProceedFromAddressPage()
	{
		new JavascriptHelper(driver).scrollIntoView(proceedAddress);
		ObjectReader.reader.getImplicitWait();
		proceedAddress.click();
		log.info("clicking proceed gto checkout button in address page");
		TestBase.logExtendReport("clicking proceed gto checkout button in address page");
			}

}
