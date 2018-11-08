package com.dd.qa.selenium.windowhandles;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testWindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\Softwares\\chromedriver_win32\\chromedriver_win32_2ndMarch\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("New driver has been initialized");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://www.popuptest.com/goodpopups.html");
		System.out.println("Popup testing site opened successfully");
		
		
		try {
			driver.findElement(By.xpath("/html/body/table[2]/tbody/tr/td/font/b/a[1]")).click();
			Thread.sleep(3000);
		} catch (Throwable t) {
			// TODO Auto-generated catch block
			t.printStackTrace();
			System.out.println("$$$$$$$$$$$Error/exception is :  "+t.getMessage());
		}
		
		Set <String> handler = driver.getWindowHandles();
		Iterator <String>  it = handler.iterator();
		
		String parentWindowID = it.next();
		String childWindowID = it.next();
		
		
		try {
			driver.switchTo().window(childWindowID);
			driver.manage().window().maximize();
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("%%%%%%%%%%Exception while switching to child window:  "+e.getMessage());
		}
		
		
		System.out.println("Title for the child windows is :     "+driver.getTitle());
		driver.close();
		
		
		
		try {
			driver.switchTo().window(parentWindowID);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Title for the parent windows is :     "+driver.getTitle());
		
		driver.quit();
		
	}

}
