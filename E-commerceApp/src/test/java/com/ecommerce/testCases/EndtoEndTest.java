package com.ecommerce.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecommerce.Base.BaseClass;
import com.ecommerce.DataProvider.DataProviders;
import com.ecommerce.pageObjects.AccountCreationPage;
import com.ecommerce.pageObjects.AddToCartPage;
import com.ecommerce.pageObjects.AddressPage;
import com.ecommerce.pageObjects.HomePage;
import com.ecommerce.pageObjects.IndexPage;
import com.ecommerce.pageObjects.LoginPage;
import com.ecommerce.pageObjects.OrderConfirmationPage;
import com.ecommerce.pageObjects.OrderPage;
import com.ecommerce.pageObjects.OrderSummaryPage;
import com.ecommerce.pageObjects.PaymentPage;
import com.ecommerce.pageObjects.SearchResultPage;
import com.ecommerce.pageObjects.ShippingPage;

public class EndtoEndTest extends BaseClass{
	IndexPage index;
	SearchResultPage SearchResult=new SearchResultPage();
	AccountCreationPage account=new AccountCreationPage();
	AddToCartPage cart=new AddToCartPage();
	LoginPage login=new LoginPage();
	HomePage homepage=new HomePage();
	OrderPage orderpage;
	AddressPage address;
	ShippingPage ship;
	PaymentPage payment;
	OrderSummaryPage ordersummary;
	OrderConfirmationPage orderconfirm;
	
	@Parameters("browsername")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browsername) {
		launchApp(browsername);
	}
	
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1,dataProvider="getProduct",dataProviderClass=DataProviders.class,groups="Regression")
	public void validateEndtoEndTest(String product,String qua,String size) throws InterruptedException {
		IndexPage index=new IndexPage();
		SearchResult=index.SearchProduct(product);
		cart=SearchResult.clickOnProduct();
		cart.enterQantity(qua);
		cart.selectSize(size);
		cart.clickAddToCartBtn();
		orderpage=cart.clickOnProceedToCheckoutBtn();
		login=orderpage.clickProceedToCheckoutBtn();
		address=login.doLogin1(prop.getProperty("username"), prop.getProperty("password"));
		ship=address.clickcheckOut();
		ship.clickCheckBox();
		payment=ship.clickproced();
		ordersummary=payment.checkPayByBank();
		orderconfirm=ordersummary.clickconfirmmyorderBtn();
		String confirm =orderconfirm.getConfirmMsg();
		Assert.assertEquals(confirm, "Your order on My Store is complete.");
		
	}

}
