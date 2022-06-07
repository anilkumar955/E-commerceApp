package com.ecommerce.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.Base.BaseClass;
import com.ecommerce.actionDriver.Action;

public class AddToCartPage extends BaseClass {
	
Action ac=new Action();
	
	@FindBy(xpath="//input[@id='quantity_wanted']")
	WebElement quantity;
	@FindBy(xpath="//select[@id='group_1']")
	WebElement size;
	@FindBy(xpath="//span[normalize-space()='Add to cart']")
	WebElement addTocartBtn;
	@FindBy(xpath="//h2[normalize-space()='Product successfully added to your shopping cart']")
	WebElement productConfirmMsg;
	
	@FindBy(xpath="//span[normalize-space()='Proceed to checkout']")
	WebElement ProceedToCheckoutBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void enterQantity(String qua) {
		ac.send(quantity, qua);
	}
	
	public void selectSize(String psize) {
		ac.selectByVisibleText(psize, size);
	}
	public void clickAddToCartBtn() {
		ac.click(driver, addTocartBtn);
	}
	
	public boolean validateAddToCartMessage() {
		return ac.isDisplayed(driver, productConfirmMsg);
			
	}
	public OrderPage clickOnProceedToCheckoutBtn() {
		ac.JSClick(driver, ProceedToCheckoutBtn);
		return new OrderPage();
		
	}

}
