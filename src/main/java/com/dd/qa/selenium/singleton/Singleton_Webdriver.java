package com.dd.qa.selenium.singleton;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Singleton_Webdriver {

	public static WebDriver driver = null;
	
	
	public static void getDriverInstance() {
		
		if(driver== null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("New driver has been initialized");
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(140, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
			
			driver.get("https://www.freecrm.com/index.html");
			System.out.println("FreeCRM site opened");
		}
		
		else {
			System.out.println("A driver already exists for this browser");
	
        }
	}	
		public static void quitBrowser() {
			driver.quit();
			driver = null;
			
		}
		
}		
