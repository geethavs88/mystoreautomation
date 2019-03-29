package com.uiFrameworkNew.companyName.projectName.pageObject;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uiFrameworkNew.companyName.projectName.helper.browserConfigurations.ObjectReader;
import com.uiFrameworkNew.companyName.projectName.helperClasses.LoggerHelper;
import com.uiFrameworkNew.companyName.projectName.helperClasses.VerificationHelper;
import com.uiFrameworkNew.companyName.projectName.helperClasses.WaitHelper;

public class ShoppingCartSummaryPage {
	
	private WebDriver driver;
	public Logger log = LoggerHelper.getLogger(ShoppingCartSummaryPage.class);
	
	public ShoppingCartSummaryPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WaitHelper waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(yourShoppingCart, ObjectReader.reader.getExplicitWait());
	}

	@FindBy(xpath="//span[text()='Your shopping cart']")
	public WebElement yourShoppingCart;
	
	@FindBy(xpath="//a[@title='Delete']")
	public List<WebElement> quantityDelete;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	public WebElement proceedToCheckOut; 
	
	@FindBy(xpath="//*[contains(text(),'Your shopping cart is empty.')]")
	public WebElement cartEmptyMessage ;
	
	public void deleteProductFromShoppingCart()
	{
		log.info("deleting all items");
		List<WebElement> deletes=quantityDelete;
		Iterator<WebElement> itr = deletes.iterator();
		while(itr.hasNext())
		{
			itr.next().click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
	}
	
	public boolean verifyProduct(String prod)
	{
		log.info("verifying whether product is displayed");
		WebElement product =driver.findElement(By.xpath("//*[contains(text(),'"+prod+"')]"));
		return new VerificationHelper(driver).isDisplayed(product);
	}
	
	public boolean emptyShoppingCart()
	{
		return new VerificationHelper(driver).isDisplayed(cartEmptyMessage);
	}
	
	
}
