package com.uiFrameworkNew.companyName.projectName.helperClasses;

public class ResourceHelper {
	
	public static String getResoucePath(String path)
	{
		String basePath = System.getProperty("user.dir");
		return basePath+"/"+path;
		
	}
	
}
