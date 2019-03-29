package com.uiFrameworkNew.companyName.projectName.testScripts;

import org.testng.annotations.Test;

import com.uiFrameworkNew.companyName.projectName.helper.browserConfigurations.ObjectReader;
import com.uiFrameworkNew.companyName.projectName.helperClasses.AssertionHelper;
import com.uiFrameworkNew.companyName.projectName.pageObject.LoginPage;
import com.uiFrameworkNew.companyName.projectName.testBase.TestBase;

public class LoginTest extends TestBase{
	
	@Test(description="Login to the application")
	public void testApplicationLogin()
	{
		getApplicationURL(ObjectReader.reader.getURL());
		LoginPage loginPage = new LoginPage(driver);
		loginPage.logInToApplication(ObjectReader.reader.getUsername(), ObjectReader.reader.getPassword());
		boolean loginStatus = loginPage.verifySuccessLogin();
		AssertionHelper.verifyTestStatus(loginStatus);
	}

	
}
