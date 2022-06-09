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
	
	@FindBy(id = "uniform-id_gender1")
	private WebElement mr;
	
	@FindBy(id = "id_gender2")
	private WebElement mrs;
	
	@FindBy(xpath="//input[@id='customer_firstname']")
	WebElement firstName;
		
	@FindBy(xpath="//input[@id='customer_lastname']")
	WebElement lasstName;

	@FindBy(xpath="//input[@id='passwd']")
	WebElement pasword;

	@FindBy(id="days")
	WebElement Days;
	@FindBy(id="months")
	WebElement months;
	@FindBy(id="years")
	WebElement years;
	@FindBy(id="company")
	WebElement company;
	@FindBy(id="address1")
	WebElement address;
	@FindBy(id="city")
	WebElement city;
	@FindBy(id="id_state")
	WebElement state;
	@FindBy(id="postcode")
	WebElement zip;
	@FindBy(id="id_country")
	WebElement country;
	@FindBy(id="phone_mobile")
	WebElement mobileNo;
	
	@FindBy(xpath="//span[normalize-space()='Register']")
	WebElement registerBtn;
	@FindBy(xpath="//input[@id='alias']")
	WebElement alis;
	public AccountCreationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getCreatePageTitle() {
		
		String accountheader=ac.text(driver,createAcountTitle);
		return accountheader;
		
	}
	public void CreateNewAccount(String gender,String fname,String lName, 
			String pswd, 
			String day, 
			String month, 
			String year,
			String comPany, 
			String addr, 
			String cityString, 
			String stateName, 
			String Zip, 
			String countryName,
			String mobilePhone) {
		
		if(gender.equalsIgnoreCase("Mr")) {
			ac.click(driver, mr);
			
		}else {
			ac.click(driver, mr);
		}
		
		ac.send(firstName, fname);
		ac.send(lasstName, lName);
		ac.send(pasword, pswd);
		ac.selectByValue(Days, day);
		ac.selectByValue(months, month);
		ac.selectByValue(years, year);
		ac.send(company, comPany);
		ac.send(address, addr);
		ac.send(city, cityString);
		ac.selectByValue(state, stateName);
		ac.send(zip, Zip);
		ac.selectByValue(country, countryName);
		ac.send(mobileNo, mobilePhone);
		
		
	}
	public HomePage DoRegister() throws InterruptedException {
		ac.click(driver, registerBtn);
		Thread.sleep(4000);
		return new HomePage();
	}
	public String validateAccountCreatePage() {
		return ac.text(driver, createAcountTitle);
	}

}
	