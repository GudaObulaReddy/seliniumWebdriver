package com.Selinium;

import java.awt.Window;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageScrollByUsingJs {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://v4-alpha.getbootstrap.com/components/dropdowns/");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*
		 * WebElement element=driver.findElement(By.id("single-button-dropdowns"));
		 * 
		 * pageScroll(element, driver);
		 */
		String element="window.scrollBy(0,10000)";
		pageScroll(element, driver);
	}
	public static void pageScroll(String string,WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript(string, string);
		
	}
	/*
	 * public static void pageScroll(WebElement element,WebDriver driver) {
	 * JavascriptExecutor js=((JavascriptExecutor)driver);
	 * js.executeScript("arguments[0].scrollIntoView();", element);//some times we can put true inside scroll
	 *
	 * }
	 */
}
