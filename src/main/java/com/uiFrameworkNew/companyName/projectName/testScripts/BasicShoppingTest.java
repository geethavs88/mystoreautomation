package com.uiFrameworkNew.companyName.projectName.testScripts;


import org.testng.annotations.Test;

import com.uiFrameworkNew.companyName.projectName.helper.browserConfigurations.ObjectReader;

import com.uiFrameworkNew.companyName.projectName.pageObject.AddressPage;
import com.uiFrameworkNew.companyName.projectName.pageObject.LoginPage;
import com.uiFrameworkNew.companyName.projectName.pageObject.MyAccountPage;
import com.uiFrameworkNew.companyName.projectName.pageObject.NavigationMenu;
import com.uiFrameworkNew.companyName.projectName.pageObject.OrderSummaryPage;
import com.uiFrameworkNew.companyName.projectName.pageObject.PaymentPage;
import com.uiFrameworkNew.companyName.projectName.pageObject.ProductCategoryPage;
import com.uiFrameworkNew.companyName.projectName.pageObject.RegistrationPage;
import com.uiFrameworkNew.companyName.projectName.pageObject.ShippingPage;
import com.uiFrameworkNew.companyName.projectName.pageObject.SummaryPage;
import com.uiFrameworkNew.companyName.projectName.testBase.TestBase;

public class BasicShoppingTest extends TestBase{
	
	
	LoginPage loginPage;
	RegistrationPage registrationPage;
	MyAccountPage myAccountPage;
	NavigationMenu navigationMenu;
	ProductCategoryPage productCategoryPage;
	SummaryPage summaryPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	
	@Test
	public void testShoppingflow()
	{
		getApplicationURL(ObjectReader.reader.getURL());
		
		loginPage = new LoginPage(driver);
		loginPage.clickOnSignInLink();
		loginPage.enterEmailAddress(ObjectReader.reader.getUsername());
		loginPage.enterPassword(ObjectReader.reader.getPassword());
		loginPage.clickSubmitButton();
		
		navigationMenu = new NavigationMenu(driver);
		navigationMenu.mouseOver("Women");
		navigationMenu.clickOnMenu(navigationMenu.women);
		
		productCategoryPage = new ProductCategoryPage(driver);
		
		productCategoryPage.mouseOverOnProduct(2);
		productCategoryPage.clickAddTocartQuikview();
		//productCategoryPage.clickOnAddToCart();
		productCategoryPage.clickOnProceedToCheckOut();
		
		
		summaryPage = new SummaryPage(driver);
		summaryPage.getListOfItems();
		summaryPage.clickOnProceedToCheckout();
		
		addressPage=new AddressPage(driver);
		addressPage.clickOnProceedFromAddressPage();
		
		shippingPage = new ShippingPage(driver);
		shippingPage.checkTermsAndConditions();
		shippingPage.clickOnProceedShippingPage();
		
		paymentPage=new PaymentPage(driver);
		paymentPage.selectPayByBankWire();
		
		orderSummaryPage = new OrderSummaryPage(driver);
		orderSummaryPage.clickOnConfirmOrder();
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
