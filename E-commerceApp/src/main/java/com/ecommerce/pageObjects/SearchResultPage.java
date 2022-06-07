package com.ecommerce.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.Base.BaseClass;
import com.ecommerce.actionDriver.Action;

public class SearchResultPage extends BaseClass{
	
	Action ac=new Action();
	
	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	WebElement productResult;
	@FindBy(xpath="//span[normalize-space()='Order history and details']")
	WebElement OrderHistory;
	
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	public boolean isProductAvailable() {
		return ac.isDisplayed(driver, productResult);
		
	}
	
	public AddToCartPage clickOnProduct() {
		ac.click(driver, productResult);
//		ac.isDisplayed(driver, productResult);
		return new AddToCartPage();
	}
	

}
