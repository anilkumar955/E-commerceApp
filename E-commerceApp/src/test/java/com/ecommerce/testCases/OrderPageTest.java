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
import com.ecommerce.pageObjects.IndexPage;
import com.ecommerce.pageObjects.OrderPage;
import com.ecommerce.pageObjects.SearchResultPage;

public class OrderPageTest extends BaseClass {
	IndexPage index=new IndexPage();
	SearchResultPage SearchResult;
	AccountCreationPage account;
	AddToCartPage cart;
	OrderPage orderpage;
	
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
	public void validateTotalPriceTest(String product,String qua,String size) throws InterruptedException {
	IndexPage index=new IndexPage();
	SearchResult=index.SearchProduct(product);
	cart=SearchResult.clickOnProduct();
	cart.enterQantity(qua);
	cart.selectSize(size);
	cart.clickAddToCartBtn();
	orderpage =cart.clickOnProceedToCheckoutBtn();
	double uprice = orderpage.getUnitPrice();
	System.out.println(uprice);
//	Thread.sleep(2000);
	double tprice=orderpage.getTotalPrice();
	System.out.println(tprice);
//	Thread.sleep(2000);
	double totalprice=(uprice*2)+2;	
	Assert.assertEquals(totalprice, tprice);
	}
	

}
