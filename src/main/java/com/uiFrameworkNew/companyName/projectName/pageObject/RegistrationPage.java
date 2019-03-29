package com.uiFrameworkNew.companyName.projectName.pageObject;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.uiFrameworkNew.companyName.projectName.helper.browserConfigurations.ObjectReader;
import com.uiFrameworkNew.companyName.projectName.helperClasses.LoggerHelper;
import com.uiFrameworkNew.companyName.projectName.helperClasses.WaitHelper;
import com.uiFrameworkNew.companyName.projectName.testBase.TestBase;

import jdk.internal.jline.internal.Log;

public class RegistrationPage {
	private WebDriver driver;
	public Logger log = LoggerHelper.getLogger(RegistrationPage.class);
			
	public RegistrationPage(WebDriver driver)
	{
		this.driver =driver;
		PageFactory.initElements(driver,this);
		WaitHelper waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(authenticationText,ObjectReader.reader.getExplicitWait());
		log.info("");
	}

	@FindBy(xpath="//span[contains(text(),'	Authentication')]")
	public WebElement authenticationText;
	
	@FindBy(xpath="//h1[contains(text(),'Create an account')]")
	public WebElement createaccountText;
	
	@FindBy(xpath="radio-inline")
	public WebElement radioText;
	
	@FindBy(xpath="//input[@id='id_gender1']")
	public WebElement mrRadioButton;
	
	@FindBy(xpath="//input[@id='id_gender2']")
	public WebElement mrsRadioButton;
	
	@FindBy(xpath="//input[@id='customer_firstname']")
	public WebElement firstName;
	
	@FindBy(xpath="//input[@id='customer_lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement password;
	
	@FindBy(xpath="//select[@id='days']")
	WebElement days;
	
	@FindBy(xpath="//select[@id='months']")
	WebElement months;
	
	@FindBy(xpath="//select[@id='years']")
	WebElement years ;
	
	@FindBy(xpath="//input[@id='firstname']")
	WebElement firstName_Address;

	@FindBy(xpath="//input[@id='lastname']")
	WebElement lastName_Address ;

	@FindBy(xpath="//input[@id='address1']")
	WebElement address_Line1;

	@FindBy(xpath="//input[@id='city']")
	WebElement city;

	@FindBy(xpath="//select[@id='id_state']")
	WebElement state;

	@FindBy(xpath="//input[@id='postcode']")
	WebElement postcode;

	@FindBy(xpath="//input[@id='phone_mobile']")
	WebElement mobilePhone;

	@FindBy(xpath="//input[@id='alias']")
	WebElement address_Alias ;

	@FindBy(xpath="//button[@id='submitAccount']")
	WebElement submit;

	@FindBy(xpath="//select[@id='id_country']")
	WebElement country;


	public void selectMrRadioButton()
	{
		mrRadioButton.click();
		log.info("Mr radio button selected");
		TestBase.logExtendReport("Mr radio button selected");
		
	}
	public void selectMrsRadioButton()
	{
		mrsRadioButton.click();
		log.info("Mrs radio button selected");
		TestBase.logExtendReport("Mrs radio button selected");
		
	}
	
	public void enterFirstName(String fName)
	{
		firstName.sendKeys(fName);
		log.info("entering first name "+fName);
		TestBase.logExtendReport("entering first name "+fName);		
	}
	public void enterLastName(String lName)
	{
		lastName.sendKeys(lName);
		log.info("entering last name "+lName);
		TestBase.logExtendReport("entering last name "+lName);		
	}
	public void enterEmail(String emailAddress)
	{
		email.sendKeys(emailAddress);
		log.info("entering email address "+emailAddress);
		TestBase.logExtendReport("entering email address "+emailAddress);		
	}
	public void enterPassword(String pswd)
	{
		password.sendKeys(pswd);
		log.info("entering password "+pswd);
		TestBase.logExtendReport("entering password "+pswd);		
	}
	public void enterCityName(String cityName)
	{
		city.sendKeys(cityName);
		log.info("entering city Name "+cityName);
		TestBase.logExtendReport("entering city name "+cityName);		
	}
	
	public void enterFirstName_Address(String fName)
	{
		firstName_Address.sendKeys(fName);
		log.info("entering first name of address"+fName);
		TestBase.logExtendReport("entering first name of address "+fName);		
	}
	public void enterLastName_Address(String lName)
	{
		lastName_Address.sendKeys(lName);
		log.info("entering last name of address "+lName);
		TestBase.logExtendReport("entering last name of address"+lName);		
	}
	public void enterAddress(String address)
	{
		address_Line1.sendKeys(address);
		log.info("entering address "+address);
		TestBase.logExtendReport("entering address "+address);		
	}
	public void enterMobilePhone(String mPhone)
	{
		mobilePhone.sendKeys(mPhone);
		log.info("entering phn number "+mPhone);
		TestBase.logExtendReport("entering phn number "+mPhone);		
	}
	public void enterPostcode(String zipCode)
	{
		postcode.sendKeys(zipCode);
		log.info("entering zipCode "+zipCode);
		TestBase.logExtendReport("entering zipCode "+zipCode);		
	}
	public void enterAddress_Alias(String add_alias)
	{
		address_Alias.sendKeys(add_alias);
		log.info("entering address alias"+add_alias);
		TestBase.logExtendReport("entering address alias "+add_alias);		
	}
	
	public void setDays(String day)
	{
		List<WebElement> days_list = driver.findElements(By.xpath("//select[@id='days']/option"));
		Iterator<WebElement> itr = days_list.iterator();
		while(itr.hasNext())
		{
			WebElement dayElement=itr.next();
			String dayText =dayElement .getText().trim().toString();
			if(dayText.equals(day))
			{
				dayElement.click();
				break;
			}
				
		}
	}
	
	public void setMonths(String month)
	{
		List<WebElement> months_list = driver.findElements(By.xpath("//select[@id='months']/option"));
		Iterator<WebElement> itr = months_list.iterator();
		while(itr.hasNext())
		{
			WebElement monthElement=itr.next();
			String monthText =monthElement .getText().trim().toString();
			if(monthText.equals(month))
			{
				monthElement.click();
				break;
			}
				
		}
	}
	
	public void setYear(String year)
	{
		List<WebElement> year_list = driver.findElements(By.xpath("//select[@id='years']/option"));
		Iterator<WebElement> itr = year_list.iterator();
		while(itr.hasNext())
		{
			WebElement yearElement=itr.next();
			String yearText =yearElement .getText().trim().toString();
			if(yearText.equals(year))
			{
				yearElement.click();
				break;
			}
				
		}
	}
	
	public void selectState(String state)
	{
		Select select =new Select(this.state);
		select.selectByVisibleText(state);
		log.info("state selected");
		TestBase.logExtendReport("state selected");
		
	}
	
	public void selectCountry(String country)
	{
		Select select =new Select(this.country);
		select.selectByVisibleText(country);
		log.info("country selected");
		TestBase.logExtendReport("country selected");
	}
	
	public void clickRegister()
	{
		submit.click();
		log.info("clicked submit register");
		TestBase.logExtendReport("clicked submit register");
		
	}
	
	
	
	
}
