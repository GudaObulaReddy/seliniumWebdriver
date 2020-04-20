package com.Selinium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutors {

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
		WebElement element=driver.findElement(By.cssSelector("#markdown-toc-examples"));
		flash(element,driver);
		System.out.println("hi");
	}
	public static void flash(WebElement element,WebDriver driver)
	{
		JavascriptExecutor  js=((JavascriptExecutor)driver);
		String bgcolor=element.getCssValue("color");
		for(int i=0;i<100;i++)
		{
			changeColor("rgb(0,200,0)",element,driver);
			changeColor(bgcolor,element,driver);
			
		}
	}
	public static void changeColor(String color,WebElement element,WebDriver driver)
	{
		JavascriptExecutor  js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.color='"+color+"'", element);
		try
		{
			Thread.sleep(20);
			
		}catch(InterruptedException e)
		{
			
		}
	}

}
