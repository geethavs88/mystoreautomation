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

public class OrderSummaryPage {
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(OrderSummaryPage.class);
	
	public OrderSummaryPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WaitHelper waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(bankWireText, ObjectReader.reader.getExplicitWait());
		new TestBase().getNavigationScreen(driver);
		log.info("Summary Page initialised");
	}
	
	
	
	
	
@FindBy(xpath="//h3[contains(text(),'Bank-wire payment.')]")
	public WebElement bankWireText;

@FindBy(xpath = "//button[@type='submit']")
WebElement confirmOrder;

@FindBy(xpath="//p[@id='cart_navigation']/a")
WebElement otherPaymentOptions;

@FindBy(xpath="//h3[contains(text(),'Check payment')]")
WebElement checkPaymentText;

public void clickOnConfirmOrder()
{
	new JavascriptHelper(driver).scrollIntoView(confirmOrder);
	ObjectReader.reader.getImplicitWait();
	confirmOrder.click();
	log.info("Confirmed order in order summary page");
	TestBase.logExtendReport("Confirmed order in order summary page");
}
	
}
