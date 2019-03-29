package com.uiFrameworkNew.companyName.projectName.testScripts;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.uiFrameworkNew.companyName.projectName.helper.browserConfigurations.ObjectReader;
import com.uiFrameworkNew.companyName.projectName.helperClasses.AssertionHelper;
import com.uiFrameworkNew.companyName.projectName.helperClasses.LoggerHelper;
import com.uiFrameworkNew.companyName.projectName.pageObject.LoginPage;
import com.uiFrameworkNew.companyName.projectName.pageObject.MyAccountPage;
import com.uiFrameworkNew.companyName.projectName.pageObject.RegistrationPage;
import com.uiFrameworkNew.companyName.projectName.testBase.TestBase;

public class RegistrationTest extends TestBase{

	private Logger log = LoggerHelper.getLogger(RegistrationTest.class);
	LoginPage loginPage;
	RegistrationPage registrationPage;
	MyAccountPage myAccountPage;
	
	@Test
	public void testLoginToApplication()
	{
		getApplicationURL(ObjectReader.reader.getURL());
		
		loginPage = new LoginPage(driver);
		loginPage.clickOnSignInLink();
		loginPage.enterRegistrationEmail();
		loginPage.clickCreateAnAccount();
		
		registrationPage =new RegistrationPage(driver);
		registrationPage.selectMrRadioButton();
		registrationPage.enterFirstName("ABCD");
		registrationPage.enterLastName("EFGH");
		registrationPage.enterPassword("password");
		registrationPage.setDays("5");
		registrationPage.setMonths("March");
		registrationPage.setYear("2000");
		registrationPage.enterFirstName_Address("ABCD");
		registrationPage.enterLastName_Address("EFGH");
		registrationPage.enterAddress("132132 asdafs sesetes awrawer");
		registrationPage.enterCityName("Redmond");
		registrationPage.enterPostcode("98052");
		registrationPage.selectState("Washington");
		registrationPage.selectCountry("United States");
		registrationPage.enterMobilePhone("2567869765");;
		registrationPage.enterAddress_Alias("arfadgsddgds sedgsd");
		
		registrationPage.clickRegister();
		
		myAccountPage = new MyAccountPage(driver);
		boolean status = myAccountPage.verifyDisplayMessage();
		
		AssertionHelper.verifyTestStatus(status);
		
	}
	
	
}
