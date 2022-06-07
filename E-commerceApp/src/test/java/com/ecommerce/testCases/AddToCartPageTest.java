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
import com.ecommerce.pageObjects.HomePage;
import com.ecommerce.pageObjects.IndexPage;
import com.ecommerce.pageObjects.LoginPage;
import com.ecommerce.pageObjects.SearchResultPage;

public class AddToCartPageTest extends BaseClass{
	IndexPage index=new IndexPage();
	SearchResultPage SearchResult=new SearchResultPage();
	AccountCreationPage account=new AccountCreationPage();
	AddToCartPage cart=new AddToCartPage();
	
	@Parameters("browsername")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browsername) {
		launchApp(browsername);
	}
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1,dataProvider="getProduct",dataProviderClass=DataProviders.class,groups={"Regression","Sanity"})
	public void validateAddToCartTest(String product,String qua,String size) {
		IndexPage index=new IndexPage();
		SearchResult=index.SearchProduct(product);
		cart=SearchResult.clickOnProduct();
		cart.enterQantity(qua);
		cart.selectSize(size);
		cart.clickAddToCartBtn();
		boolean msg=cart.validateAddToCartMessage();
		Assert.assertTrue(msg);
		
		
		
	}
	

}
