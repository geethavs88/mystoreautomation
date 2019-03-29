package com.uiFrameworkNew.companyName.projectName.helperClasses;

import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WindowHelper {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(WindowHelper.class);

	public WindowHelper(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * This method will switch to parent window
	 */
	public void switchToParentWindow() {

		driver.switchTo().defaultContent();
		log.info("Switching to default window");

	}

	/**
	 * This method will switch to window based on index
	 * 
	 * @param index
	 */
	public void switchToWindow(int index) {

		Set<String> windows = driver.getWindowHandles();
		int i = 1;
		log.info("Switch to window based on index");
		for (String window : windows) {
			if (i == index) {
				driver.switchTo().window(window);
			}
			i++;

		}
	}

	/**
	 * This method will close all tabbed windows and switch to main window
	 */

	public void closeAllTabsAndSwitchToMainWindow() {
		Set<String> windows = driver.getWindowHandles();
		String mainWindow = driver.getWindowHandle();

		for (String window : windows) {
			if (!window.equalsIgnoreCase(mainWindow)) {
				driver.close();

			}

		}
		log.info("Switch to main window after closing all other windows");
		driver.switchTo().window(mainWindow);

	}

	/**
	 * This method will navigate backwards
	 */
	public void navigateBack() {
		log.info("Navigating backwards");
		driver.navigate().back();
	}

	/**
	 * This method will navigate forward
	 */
	public void navigateForward()

	{
		log.info("Navigating forwards");
		driver.navigate().forward();
	}
}
