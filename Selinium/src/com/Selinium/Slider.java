package com.Selinium;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/jquery-download-progress-bar-demo.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       
       Actions act=new Actions(driver);
       driver.findElement(By.cssSelector("#downloadButton")).click();
       Thread.sleep(3000);
       System.out.println(driver.findElement(By.cssSelector("div[class=\"progress-label\"]")).getText());
       driver.findElement(By.cssSelector("div[class=\"ui-dialog-buttonset\"] button")).click();
       System.out.println(driver.findElement(By.cssSelector("div[class=\"progress-label\"]")).getText());   
	}                 

}
