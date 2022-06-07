package com.ecommerce.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.Base.BaseClass;
import com.ecommerce.actionDriver.Action;

public class AddressPage extends BaseClass{
	Action ac=new Action();
	
	@FindBy(xpath="//span[@class='navigation_page']")
	WebElement AddressTitle;
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement proceedCheckout;
			
	
	public AddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getAddressPageTitle() {
		return AddressTitle.getText();
	}
	
	public ShippingPage clickcheckOut() {
		ac.click(driver, proceedCheckout);
		return new ShippingPage();
	}

}
