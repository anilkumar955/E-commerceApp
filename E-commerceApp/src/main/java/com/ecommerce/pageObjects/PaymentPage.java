package com.ecommerce.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.Base.BaseClass;
import com.ecommerce.actionDriver.Action;

public class PaymentPage extends BaseClass {
Action ac=new Action();
	
	@FindBy(xpath="//a[@title='Pay by bank wire']")
	WebElement payByBank;
	
	@FindBy(xpath="//a[@title='Pay by check.']]")
	WebElement payBycheck;
	
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public OrderSummaryPage checkPayByBank() {
		ac.click(driver, payByBank);
		return new OrderSummaryPage();
		
	}
//	public boolean checkPayByCheck() {
//		ac.isDisplayed(driver, payBycheck);
//		
//	}

}
