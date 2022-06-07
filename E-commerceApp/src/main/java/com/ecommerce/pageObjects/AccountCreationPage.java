package com.ecommerce.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.Base.BaseClass;
import com.ecommerce.actionDriver.Action;

public class AccountCreationPage extends BaseClass{
	Action ac=new Action();
	
	@FindBy(xpath="//h1[text()='Create an account']")
	WebElement createAcountTitle;
	
	
	public AccountCreationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getCreatePageTitle() {
		
		String accountheader=ac.text(driver,createAcountTitle);
		return accountheader;
		
	}
	

}
	