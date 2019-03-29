package com.uiFrameworkNew.companyName.projectName.helper.browserConfigurations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.uiFrameworkNew.companyName.projectName.helper.browserConfigurations.BrowserType;
import com.uiFrameworkNew.companyName.projectName.helperClasses.ResourceHelper;

public class PropertyReader implements IConfigReader {
	private static FileInputStream file;
	public static Properties OR;

	public PropertyReader(){
		String filePath = ResourceHelper.getResoucePath("src/main/resources/configfile/config.properties");
		 try {
			file = new FileInputStream(new File(filePath)) ;
			OR = new Properties();
			
				OR.load(file);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getImplicitWait() {
		// TODO Auto-generated method stub
		return Integer.parseInt(OR.getProperty("implicitwait"));
	}

	public int getExplicitWait() {
		// TODO Auto-generated method stub
		return Integer.parseInt(OR.getProperty("explicitwait"));
	}

	public int getPageLoadTime() {
		// TODO Auto-generated method stub
		return Integer.parseInt(OR.getProperty("pageloadtime"));
	}

	public BrowserType getBrowserType() {
		// TODO Auto-generated method stub
		return BrowserType.valueOf(OR.getProperty("browserType"));
	}

	public String getURL() {
		return OR.getProperty("applicationURL");
		
	}
	
	public String getPassword() {
		return OR.getProperty("password");
	}
	public String getUsername() {
		// TODO Auto-generated method stub
		return OR.getProperty("username");
	}
}