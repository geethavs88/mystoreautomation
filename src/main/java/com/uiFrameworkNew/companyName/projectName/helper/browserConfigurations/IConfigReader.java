package com.uiFrameworkNew.companyName.projectName.helper.browserConfigurations;

public interface IConfigReader {

	public int getImplicitWait();
	public int getExplicitWait();
	public int getPageLoadTime();
	public BrowserType getBrowserType();
	public String getURL();
	public String getUsername();
	public String getPassword();
	
	
	
}
