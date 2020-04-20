package com.Selinium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://leafground.com/pages/disapper.html");
		/*
		 * WebDriverWait wait1=new WebDriverWait(driver, 8);
		 * wait1.until(ExpectedConditions.visibilityOf(driver.findElement(By.
		 * xpath("//*[contains(text(),'here Guys')]"))));
		 * System.out.println(driver.findElement(By.
		 * xpath("//*[contains(text(),'here Guys')]")).getText()); Thread.sleep(1000);
		 */
		WebElement element=driver.findElement(By.xpath("//button[@id='btn']"));
		System.out.println(element.getText());
		System.out.println(element.isDisplayed());
		WebDriverWait wait2=new WebDriverWait(driver, 8);
		wait2.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//button[@id='btn']"))));
		System.out.println(element.getText());
		System.out.println(element.isDisplayed());
	}

}
