package com.ecommerce.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.Base.BaseClass;
import com.ecommerce.actionDriver.Action;

public class OrderSummaryPage extends BaseClass {
Action ac=new Action();
	
	@FindBy(xpath="//span[normalize-space()='I confirm my order']")
	WebElement confirmmyorderBtn;
	
	
	public OrderSummaryPage() {
		PageFactory.initElements(driver, this);
	}
	public OrderConfirmationPage clickconfirmmyorderBtn() {
		ac.click(driver, confirmmyorderBtn);
		return new OrderConfirmationPage();
	}
}
