package com.ecommerce.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.Base.BaseClass;
import com.ecommerce.actionDriver.Action;

public class OrderPage extends BaseClass {
	
Action ac=new Action();
	
	@FindBy(xpath="//td[@class='cart_unit']/span/span")
	WebElement unitPrice;
	
	@FindBy(id="total_price")
	WebElement totalPrice;
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	WebElement ProceedTocheckOutBtn;
	
	
	public OrderPage() {
		PageFactory.initElements(driver, this);
	}
	
	public double getUnitPrice() {
		String unitprice =unitPrice.getText();
		String unit=unitprice.replaceAll("[^a-zA-Z0-9]","");
		double finalUnitPrice =Double.parseDouble(unit);
		return finalUnitPrice/100;
	}
	public double getTotalPrice() {
		String Totalprice =totalPrice.getText();
		String total=Totalprice.replaceAll("[^a-zA-Z0-9]","");
		double finalTotalPrice =Double.parseDouble(total);
		return finalTotalPrice/100;
		
	}
	public LoginPage clickProceedToCheckoutBtn() {
		ac.click(driver, ProceedTocheckOutBtn);
		return new LoginPage();
	}
	

}
