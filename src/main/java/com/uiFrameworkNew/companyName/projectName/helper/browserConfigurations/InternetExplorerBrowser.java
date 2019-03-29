package com.uiFrameworkNew.companyName.projectName.helper.browserConfigurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.ElementScrollBehavior;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class InternetExplorerBrowser {

	public InternetExplorerOptions getIEOptions()
	{
		DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
		
		cap.setJavascriptEnabled(true);
		cap.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR, ElementScrollBehavior.BOTTOM);
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);
		cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		
		InternetExplorerOptions options = new InternetExplorerOptions(cap);
		return options;
		
	}
	
	public WebDriver getInternetexplorerDriver(InternetExplorerOptions cap)
	{
		System.setProperty("webdriver.internetexplorer.driver","src/main/resources/drivers/internetexplorer.exe");
		return new InternetExplorerDriver(cap);
	}
}
