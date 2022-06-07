package com.ecommerce.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.Base.BaseClass;
import com.ecommerce.actionDriver.Action;

public class ShippingPage extends BaseClass{
Action ac=new Action();
	
	@FindBy(xpath="//h1[text()='Shipping']")
	WebElement ShippingPageTitle;
	
	@FindBy(xpath="//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")
	WebElement proceedCheckout;
	@FindBy(xpath="//input[@id='cgv']")
	WebElement termsCheckBox;
	
	public ShippingPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String getShippingPageTitle() {
		return ShippingPageTitle.toString();
	}
	
	public void clickCheckBox() {
		ac.mouseOverElement(driver, termsCheckBox);
	}
	
	public PaymentPage clickproced() {
		ac.click(driver, proceedCheckout);
		return new PaymentPage();
	}

}
