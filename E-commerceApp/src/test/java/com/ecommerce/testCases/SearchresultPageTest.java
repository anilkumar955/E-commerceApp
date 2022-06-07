package com.ecommerce.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecommerce.Base.BaseClass;
import com.ecommerce.DataProvider.DataProviders;
import com.ecommerce.pageObjects.IndexPage;
import com.ecommerce.pageObjects.SearchResultPage;

public class SearchresultPageTest extends BaseClass{
IndexPage index;
SearchResultPage SearchResult=new SearchResultPage();
	

	@Parameters("browsername")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browsername) {
		launchApp(browsername);
	}
	
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
		
	}
	
	@Test(priority=1,dataProvider="searchProduct",dataProviderClass=DataProviders.class,groups="Smoke")
	public void validateSearchProductTest(String products) {
		IndexPage index=new IndexPage();
		SearchResult=index.SearchProduct(products);
		boolean product=SearchResult.isProductAvailable();
		Assert.assertTrue(product);
	
	}

}
