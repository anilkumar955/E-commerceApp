package com.ecommerce.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecommerce.Base.BaseClass;
import com.ecommerce.pageObjects.IndexPage;
import com.ecommerce.utility.Log;

public class IndexPageTest extends BaseClass {
	IndexPage index;
	
	@Parameters("browsername")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browsername) {
		launchApp(browsername);
	}
	
	
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1,groups="Smoke")
	public void validateAppLogo() {
		Log.startTestCase("validateAppLogo");
		index=new IndexPage();
		Log.info("verifying the logo");
		boolean logo =index.validateLogo();
		Assert.assertTrue(logo);
	}
	
	@Test(priority=2,groups="Smoke")
	public void validateIndexPageTitle() {
		Log.startTestCase("validateIndexPageTitle");
		String title =index.getPageTitle();
		Log.info("verifying the title");
		Assert.assertEquals(title,"My Store");
	}
	
	

}
