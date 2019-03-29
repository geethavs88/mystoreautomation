package com.uiFrameworkNew.companyName.projectName.helper.browserConfigurations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeBrowser {
	
	public ChromeOptions getChromeOptions()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--test-type");
		options.addArguments("--disabled-popup-blocking");
		
		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		chrome.setJavascriptEnabled(true);
		options.setCapability(ChromeOptions.CAPABILITY,chrome);
		
		return options;
		
	}

	public WebDriver getChromeDriver(ChromeOptions cap)
	{
		if(System.getProperty("os.name").contains("Windows"))
		{
			//ResourceHelper.getResoucePath("src/main/resources/drivers/chrome.exe")
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sreejith\\eclipse-workspace\\selenium\\driver\\chromedriver.exe");
			return new ChromeDriver(cap);
		}
		return null;
	}
}
