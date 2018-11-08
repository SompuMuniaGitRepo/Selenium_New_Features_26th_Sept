package com.dd.qa.selenium.windowhandles;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class winhandlewithHelper {
	
	public static WebDriver driver = null;

	public static void switchToWindowIndex(int index) {
		
		String windowID = null;
		Set <String> handler = driver.getWindowHandles();
		Iterator <String>  it = handler.iterator();
		
		for(int i=1; i<=index;i++) {
			
			 windowID = it.next();
		}
		driver.switchTo().window(windowID);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\Softwares\\chromedriver_win32\\chromedriver_win32_2ndMarch\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("New driver has been initialized");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
    	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("http://demo.automationtesting.in/Windows.html");
		System.out.println("Demo Automation.in site opened successfully");
		
		
		try {
			driver.findElement(By.xpath("//*[@id=\"Tabbed\"]/a/button")).click();
			Thread.sleep(3000);
		} catch (Throwable t) {
			// TODO Auto-generated catch block
			t.printStackTrace();
			System.out.println("$$$$$$$$$$$Error/exception is :  "+t.getMessage());
		}
		
		
		try {
			switchToWindowIndex(2);
			Thread.sleep(3000);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("%%%%%%%%%%%Exception occured while switching to child window: "+e.getMessage());
		}
		
		System.out.println("Child window title is:   "+driver.getTitle());
//		driver.close();
		
		
		try {
			switchToWindowIndex(1);
			System.out.println("Parent window title is:   "+driver.getTitle());
			Thread.sleep(2000);
		} catch (Exception exc) {
			// TODO Auto-generated catch block
			exc.printStackTrace();
			System.out.println("**************Exception while switching back to parent window:   "+exc.getMessage());
		}
		
		
		
		try {
			Thread.sleep(3000);
			switchToWindowIndex(4);
		} catch (Exception er) {
			// TODO Auto-generated catch block
			er.printStackTrace();
			System.out.println("##########Exception while switching for the last time:   "+er.getMessage());
		}
		
		
    }

}
