package com.ecommerce.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.Base.BaseClass;
import com.ecommerce.actionDriver.Action;

public class LoginPage extends BaseClass{
	
Action ac=new Action();
	
	@FindBy(xpath="//input[@id='email']")
	WebElement username;
	@FindBy(xpath="//input[@id='passwd']")
	WebElement password;
	
	@FindBy(xpath="//span[normalize-space()='Sign in']")
	WebElement signInBtn;
	
	@FindBy(xpath="//input[@id='email_create']")
	WebElement emailID;
	
	@FindBy(xpath="//span[normalize-space()='Create an account']")
	WebElement createAccount;
	
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public HomePage doLogin(String un,String pw) throws InterruptedException {
		ac.send(username, un);
		ac.send(password, pw);
		ac.click(driver, signInBtn);
		return new HomePage();
		
	}
	public AddressPage doLogin1(String un,String pw) {
		ac.send(username, un);
		ac.send(password, pw);
		ac.click(driver, signInBtn);
		return new AddressPage();
		
	}
	
	public AccountCreationPage createAccount(String email) {
		ac.send(emailID, email);
		ac.click(driver, createAccount);
		return new AccountCreationPage();
	}
	


}
