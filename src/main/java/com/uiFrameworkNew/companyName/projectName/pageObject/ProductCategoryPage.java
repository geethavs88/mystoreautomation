package com.uiFrameworkNew.companyName.projectName.pageObject;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.uiFrameworkNew.companyName.projectName.helper.browserConfigurations.ObjectReader;
import com.uiFrameworkNew.companyName.projectName.helperClasses.JavascriptHelper;
import com.uiFrameworkNew.companyName.projectName.helperClasses.LoggerHelper;
import com.uiFrameworkNew.companyName.projectName.helperClasses.WaitHelper;
import com.uiFrameworkNew.companyName.projectName.testBase.TestBase;

public class ProductCategoryPage {

	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(ProductCategoryPage.class);
			
			
			public ProductCategoryPage(WebDriver driver)
			{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		WaitHelper waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(catalog, ObjectReader.reader.getExplicitWait());
		log.info("Product category page initialised");
		TestBase.logExtendReport("Product category page initialised");
		new TestBase().getNavigationScreen(driver);
			}
			
			@FindBy(xpath="//p[contains(text(),'Catalog')]")
			public WebElement catalog;
			
			@FindBy(xpath="//p[@id='add_to_cart']/button")
			public WebElement addToCart;
			
			@FindBy(xpath="//div[@id='layer_cart']/div/div[1]/h2")
			public WebElement productAddedSuccessfully;
			
			@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
			//@FindBy(xpath="//div[@id='layer_cart']/div[1]/div[2]/div[4]/a")
			public WebElement proceedToCheckOut;
			
			@FindBy(xpath="//*[@id=\"center_column\"]/ul/li")
			List<WebElement> totalProducts;
			
			@FindBy(xpath="//select[@id='selectProductSort']")
			public WebElement sortBy;
			
			@FindBy(xpath="//*[@id=\"center_column\"]/ul/li/div/div[2]/div[1]/span[1]")
			List<WebElement> allPriceElements;
			@FindBy(xpath="//span[@id='layered_price_range']")
			public WebElement range;
			
			@FindBy(xpath="(//a[@title=\"Add to cart\"]/span)[2]")
			public WebElement addToCartQuick;
			
			
			
			
			public void mouseOverOnProduct(int number)
			{
				String firstPart="//*[@id='center_column']/ul/li[";
				String secondPart="]/div/div[2]/h5/a";
				String product = firstPart+number+secondPart;
				new JavascriptHelper(driver).scrollIntoView(driver.findElement(By.xpath(product)));
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElement(By.xpath(firstPart+number+secondPart))).build().perform();
				//action.doubleClick(driver.findElement(By.xpath(firstPart+number+secondPart))).build().perform();
				

				log.info("Mouse over on Product");
				
			}
			
			public void clickOnAddToCart()
			{
				
				//new JavascriptHelper(driver).scrollIntoView(addToCart);
				addToCart.click();
				log.info("Adding the product to cart");
				
				
			}
			
			public void clickAddTocartQuikview()
			{
				//String firstPart="//*[@id=\"center_column\"]/ul/li[";
				//String secondPart="]/div/div[2]/div[2]/a[1]";
				//String product=firstPart+number+secondPart;
				//WebElement addToCartQuick = driver.findElement(By.xpath(product));
				
			//new JavascriptHelper(driver).scrollToElementAndClick(addToCartQuick);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				addToCartQuick.click();
			log.info("Adding the product to the cart");
			}
			
			public void clickOnProceedToCheckOut() 
			
			{
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				new JavascriptHelper(driver).scrollToElement(proceedToCheckOut);
				//Actions action = new Actions(driver);
				//action.moveToElement(proceedToCheckOut).click().build().perform();
				proceedToCheckOut.click();
				log.info("clicking on proceed to checkout");
				
			
				
				
			}
			
			public void selectColour(String data)
			{
				new JavascriptHelper(driver).scrollIntoView(driver.findElement(By.xpath("//a[contains(text(),'"+data+"')]/parent::*/preceding-sibling::input[1]")));
				driver.findElement(By.xpath("//a[contains(text(),'"+data+"')]/parent::*/preceding-sibling::input[1]")).click();
				try {
					Thread.sleep(7000);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}
			
			public void selectSize(String size)
			{
				log.info("Selecting size : "+size);
				driver.findElement(By.xpath("//ul[@id='ul_layered_id_attribute_group_1']/li/label/a[contains(text(),'"+size+"')]/parent::*/preceding-sibling::*/span/input")).click();
			}
			
			public void selectFirstProduct()
			{
			
				Actions action = new Actions(driver);
				action.moveToElement(totalProducts.get(0)).build().perform();
				log.info("Selecting first product");
				addToCart.click();
				log.info("Adding the selected product to cart");
				TestBase.logExtendReport("Adding the selected product to cart");
			}
			
			public int getTotalProducts()
			{
				return totalProducts.size();
			}
		
			public List<WebElement> getAllProductsPrice()
			{
				return allPriceElements;
				
			}
			
			public void selectSortByFilter(String dataToSelect)
			{
				Select select = new Select(sortBy);
				select.selectByVisibleText(dataToSelect);
				log.info("Selecting sort by filter : "+dataToSelect);
				
			}
					
}
