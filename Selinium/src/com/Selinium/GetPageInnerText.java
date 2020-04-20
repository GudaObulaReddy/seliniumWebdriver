package com.Selinium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetPageInnerText {

	public static void main(String[] args)
	{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.facebook.com");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	System.out.println(getPageInnerTextByJs(driver));
		
	}
	public static String getPageInnerTextByJs(WebDriver driver)
	{
		JavascriptExecutor js=((JavascriptExecutor)driver);
		String pageText=js.executeScript("return document.documentElement.innerText;").toString();
		return pageText;
	}

}
