package com.ecommerce.testCases;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ecommerce.Base.BaseClass;
import com.ecommerce.DataProvider.DataProviders;
import com.ecommerce.pageObjects.AccountCreationPage;
import com.ecommerce.pageObjects.HomePage;
import com.ecommerce.pageObjects.IndexPage;
import com.ecommerce.pageObjects.LoginPage;

public class AccountCreationPageTest extends BaseClass {
	
	IndexPage index=new IndexPage();
	LoginPage login=new LoginPage();
	HomePage homepage=new HomePage();
	AccountCreationPage account=new AccountCreationPage();
	
	
	@Parameters("browsername")
	@BeforeMethod(groups= {"Smoke","Sanity","Regression"})
	public void setup(String browsername) {
		launchApp(browsername);
	}
	@AfterMethod(groups= {"Smoke","Sanity","Regression"})
	public void tearDown() {
		driver.quit();
	}
//	@Test(priority=1,dataProvider="email",dataProviderClass=DataProviders.class,groups="Sanity")
//	public void AccountPageTitleTest(String email) throws InterruptedException {
//		IndexPage index=new IndexPage();
//		login=index.clickOnSignInButton();	
//		account=login.createAccount(email);
//		String title=account.getCreatePageTitle();
//		Assert.assertEquals(title, "CREATE AN ACCOUNT");
//		
//	}
	@Test(priority=2,dataProvider="newAcountDetailsData",dataProviderClass=DataProviders.class,groups="Regression")
	public void validateAccountCreateTest(HashMap<String,String> hashMapValue) throws InterruptedException {
		IndexPage index=new IndexPage();
		login=index.clickOnSignInButton();	
		account=login.createAccount(hashMapValue.get("Email"));
		
		account.CreateNewAccount(hashMapValue.get("Gender"),
				hashMapValue.get("FirstName"),
				hashMapValue.get("LastName"),
				hashMapValue.get("SetPassword"),
				hashMapValue.get("Day"),
				hashMapValue.get("Month"),
				hashMapValue.get("Year"),
				hashMapValue.get("Company"),
				hashMapValue.get("Address"),
				hashMapValue.get("City"),
				hashMapValue.get("State"),
				hashMapValue.get("Zipcode"),
				hashMapValue.get("Country"),
				hashMapValue.get("MobilePhone"));
		homepage=account.DoRegister();
		Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", homepage.checkHomeUrl());
	}

}
