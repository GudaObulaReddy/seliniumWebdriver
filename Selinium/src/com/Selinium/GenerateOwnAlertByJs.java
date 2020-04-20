package com.Selinium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GenerateOwnAlertByJs {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		generateAlert(driver, "do you want subscribe");
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
		
	}
	public static void generateAlert(WebDriver driver, String message)
	{
		JavascriptExecutor js=((JavascriptExecutor) driver);
		js.executeScript("alert('"+message+"')");
	}

}
