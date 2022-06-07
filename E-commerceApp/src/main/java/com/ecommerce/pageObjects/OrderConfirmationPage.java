package com.ecommerce.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.Base.BaseClass;
import com.ecommerce.actionDriver.Action;

public class OrderConfirmationPage extends BaseClass{
Action ac=new Action();
	
	@FindBy(xpath="//p/strong[contains(text(),'Your order on My Store is complete.')]")
	WebElement OrderConfirmationText;
	
	
	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getConfirmMsg() {
		return OrderConfirmationText.getText();
		
	}

}
