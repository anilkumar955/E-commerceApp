package com.ecommerce.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecommerce.Base.BaseClass;
import com.ecommerce.pageObjects.HomePage;
import com.ecommerce.pageObjects.IndexPage;
import com.ecommerce.pageObjects.LoginPage;

public class HomePageTest extends BaseClass {
	IndexPage index=new IndexPage();
	LoginPage login=new LoginPage();
	HomePage homepage=new HomePage();
	
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
	public void validateCheckAvailabilityOfMyWishListTest() throws InterruptedException {
		IndexPage index=new IndexPage();
		login=index.clickOnSignInButton();
		homepage=login.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		String wishlist = homepage.CheckAvailabilityOfMyWishList();
		Assert.assertEquals(wishlist, "MY WISHLISTS");
		
	}
	@Test(priority=2,groups="Smoke")
	public void validateOrderHistorytest() throws InterruptedException {
		IndexPage index=new IndexPage();
		login=index.clickOnSignInButton();
		homepage=login.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		String history =homepage.CheckOrderHistory();
		System.out.println(history);
		Assert.assertEquals(history, "ORDER HISTORY AND DETAILS");
//		Thread.sleep(2000);
	}

}
