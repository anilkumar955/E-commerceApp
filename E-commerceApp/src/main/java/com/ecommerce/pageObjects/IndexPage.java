package com.ecommerce.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.Base.BaseClass;
import com.ecommerce.actionDriver.Action;

public class IndexPage extends BaseClass{
	Action ac=new Action();
	
	@FindBy(xpath="//img[@alt='My Store']")
	WebElement AppLogo;
	
	@FindBy(xpath="//input[@id='search_query_top']")
	WebElement SearchBox;
	@FindBy(xpath = "//a[@class='login']") 
	private WebElement signInBtn;
	@FindBy(name="submit_search")
	private WebElement searchButton;
	
	
	public IndexPage() {
		PageFactory.initElements(driver,this);
	}
	
	public LoginPage clickOnSignInButton(){
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		ac.JSClick(driver, signInBtn);
		ac.JSClick(driver, signInBtn);
		return new LoginPage();
		
	}
	public boolean validateLogo() {
		boolean logo =ac.isDisplayed(driver, AppLogo);
		return logo;
	}
	
	public String getPageTitle() {
		String title=ac.getTitle(driver);
		return title;
	}
	public SearchResultPage SearchProduct(String productName) {
		ac.send(SearchBox, productName);
		ac.click(driver, searchButton);
		return new SearchResultPage();
	}
	

	

}
