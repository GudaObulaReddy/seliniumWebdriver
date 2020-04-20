package com.Selinium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RefreshPageAndGetTitleByJs {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		WebElement element=driver.findElement(By.linkText("Log In"));
		driver.navigate().refresh();// this is normal
		RefreshBrowser(driver);// by js
		System.out.println(getTitleByJs(driver));
	}
	public static void RefreshBrowser(WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
	}
	public static String getTitleByJs(WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		String title=js.executeScript("return document.title;").toString();
		return title;
	}
	}


