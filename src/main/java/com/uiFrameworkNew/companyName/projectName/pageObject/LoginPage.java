package com.uiFrameworkNew.companyName.projectName.pageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.uiFrameworkNew.companyName.projectName.helper.browserConfigurations.ObjectReader;
import com.uiFrameworkNew.companyName.projectName.helperClasses.JavascriptHelper;
import com.uiFrameworkNew.companyName.projectName.helperClasses.LoggerHelper;
import com.uiFrameworkNew.companyName.projectName.helperClasses.VerificationHelper;
import com.uiFrameworkNew.companyName.projectName.helperClasses.WaitHelper;
import com.uiFrameworkNew.companyName.projectName.testBase.TestBase;

public class LoginPage {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(LoginPage.class);
	
	WaitHelper waitHelper;
	
	@FindBy(xpath="//a[@class='login']")
	WebElement signIn;
	
	@FindBy(xpath="//input[@name='email_create']")
	WebElement registrationEmailAddress;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement signInEmailAddress;
	
	@FindBy(xpath="//input[@name='passwd']")
	WebElement signInPassword;
	
	@FindBy(xpath="//button[@name='SubmitLogin']")
	WebElement submitLogin;
	
	@FindBy(xpath="//button[@name='SubmitCreate']")
	WebElement submitCreate;
	
	@FindBy(xpath="//h1[text()='Authentication']")
	WebElement authenticationText;
	
	@FindBy(xpath="//h3[text()='Create an account']")
	WebElement createAccountText;
	
	@FindBy(xpath="//a[contains(text(),'Forgot')]")
	WebElement forgotPassword;
	
	@FindBy(xpath="//p[contains(text(),'Welcome to your account')]")
	WebElement successMsgObject;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(signIn,ObjectReader.reader.getExplicitWait());
		new TestBase().getNavigationScreen(driver);
	}
	
	public void clickOnSignInLink()
	{
		log.info("clicking on sign in link");
		logExtendReport("clicking on sign in link");
		signIn.click();
		
	}
	
	public void enterEmailAddress(String emailAddress)
	{
		log.info("entering email address");
		logExtendReport("entering email address");
		signInEmailAddress.sendKeys(emailAddress);
	}
	
	public void enterPassword(String password)
	{
		log.info("Entering password");
		logExtendReport("Entering password");
		signInPassword.sendKeys(password);
		
	}
	
	public void enterRegistrationEmail()
	{
		String emailAddress = System.currentTimeMillis()+"@gmail.com";
		log.info("Entering registration email address");
		logExtendReport("Entering registration email address");
		registrationEmailAddress.sendKeys(emailAddress);
		
	}
	
	public HomePage clickSubmitButton()
	{
		log.info("clicking submit button");
		logExtendReport("clicking submit button");
		new JavascriptHelper(driver).scrollDownVertically();
		submitLogin.click();
		return new HomePage(driver);
		
	}
	
	public RegistrationPage clickCreateAnAccount()
	{
		log.info("clicking create an account button");
		submitCreate.click();
		return new RegistrationPage(driver);
	}
	
	public boolean verifySuccessLogin()
	{
		return new VerificationHelper(driver).isDisplayed(successMsgObject);
	}
	
	public void logInToApplication(String emailAddress,String password)
	{
		clickOnSignInLink();
		enterEmailAddress(emailAddress);
		enterPassword(password);
		clickSubmitButton();
		
		
		
	}
	public void logExtendReport(String s1)
	{
		TestBase.test.log(Status.INFO,s1);
		
	}
	
}
