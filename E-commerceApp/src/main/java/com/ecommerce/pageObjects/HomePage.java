package com.ecommerce.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.Base.BaseClass;
import com.ecommerce.actionDriver.Action;

public class HomePage extends BaseClass{
	
	
	Action ac=new Action();
	
	@FindBy(xpath="//span[normalize-space()='My wishlists']")
	WebElement MyWishList;
	@FindBy(xpath="//span[text()='Order history and details']")
	WebElement OrderHistory;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String CheckAvailabilityOfMyWishList() {
		return ac.text(driver, MyWishList);
	}
	
	public String CheckOrderHistory() {
		return ac.text(driver, OrderHistory);
	}
	public String checkHomeUrl() {
		String homeURL=driver.getCurrentUrl();
		return homeURL;
	}

}
