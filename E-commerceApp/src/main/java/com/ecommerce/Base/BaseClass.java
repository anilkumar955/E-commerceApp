package com.ecommerce.Base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.ecommerce.actionDriver.Action;
import com.ecommerce.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;
	
	@BeforeSuite(groups= {"Smoke","Sanity","Regression"})
	public void beforeSuite() {
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		try {
			prop=new Properties();
			FileInputStream ip=new FileInputStream("D:\\Anil\\JAVA_Selenium\\Selenium_Workspace\\E-commerceApp\\Configuration\\config.properties");
		prop.load(ip);	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
//	
//	@BeforeTest(groups= {"Smoke","Sanity","Regression"})
//	public void loadConfig() throws FileNotFoundException {
//		
//		try {
//			prop=new Properties();
//			FileInputStream ip=new FileInputStream("D:\\Anil\\JAVA_Selenium\\Selenium_Workspace\\E-commerceApp\\Configuration\\config.properties");
//		prop.load(ip);	
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	
	public static void launchApp(String browser) {
		WebDriverManager.chromedriver().setup();
//		String browser=prop.getProperty("browser");
		if(browser.contains("Chrome")) {
			driver= new ChromeDriver();
		}
		else if(browser.contains("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else {
			System.out.println("no browser is defined");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
		
			
		}
	
	@AfterSuite(groups = { "Smoke", "Regression","Sanity" })
	public void afterSuite() {
		ExtentManager.endReport();
	}
		
	
	

}
