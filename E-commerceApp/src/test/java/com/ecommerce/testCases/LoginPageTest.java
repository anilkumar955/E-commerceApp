package com.ecommerce.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecommerce.Base.BaseClass;
import com.ecommerce.DataProvider.DataProviders;
import com.ecommerce.pageObjects.HomePage;
import com.ecommerce.pageObjects.IndexPage;
import com.ecommerce.pageObjects.LoginPage;
import com.ecommerce.utility.Log;

public class LoginPageTest extends BaseClass {
	
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
	
	@Test(priority=1,dataProvider="credentials",dataProviderClass=DataProviders.class,groups= {"Smoke","Sanity"})
	public void ValidateloginTest(String uname,String pword) throws InterruptedException{
		Log.startTestCase("ValidateloginTest");
		IndexPage index=new IndexPage();
		Log.info("user is going to click on signin button");
		login=index.clickOnSignInButton();
		Log.info("entering the user name and password");
		homepage=login.doLogin(uname,pword);
//		homepage=login.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		String homeurl =homepage.checkHomeUrl();
		Log.info("checking user is log in to application successfully or not");
		Assert.assertEquals(homeurl, "http://automationpractice.com/index.php?controller=my-account");
	}
	
	

}
