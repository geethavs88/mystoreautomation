package com.uiFrameworkNew.companyName.projectName.helper.browserConfigurations;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxBrowser {

	public FirefoxOptions getFirefoxOptions()
	{
		DesiredCapabilities firefox = DesiredCapabilities.firefox();
		
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAssumeUntrustedCertificateIssuer(true);
		profile.setAcceptUntrustedCertificates(true);
		
		firefox.setCapability(FirefoxDriver.PROFILE,profile);
		firefox.setCapability("marionette",true);
		
		FirefoxOptions firefoxOptions = new FirefoxOptions(firefox);
		
		return firefoxOptions;
		
				
	}
	
	public WebDriver getFirefoxDriver(FirefoxOptions cap)
	{
		if(System.getProperty("os.name").contains("Windows"))
		{
			System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/gecodriver.exe");
			return new FirefoxDriver(cap);
		}
		return null;
	}
}
