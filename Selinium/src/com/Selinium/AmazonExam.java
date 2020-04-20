package com.Selinium;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonExam {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe"); 
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		 driver.manage().window().maximize(); driver.manage().deleteAllCookies();
		  driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("mask"+Keys.ARROW_DOWN+Keys.ARROW_DOWN+Keys.ENTER);
		 // driver.findElement(By.cssSelector("#twotabsearchtextbox")).click();
		 
		  WebElement rating=driver.findElement(By.xpath("//*[@aria-label='4 Stars & Up']"));
			rating.click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id=\"p_89/3M\"]/span/a/div/label/i")).click();;
			
			driver.findElement(By.xpath("//*[@id=\"p_89/3M\"]/span/a/span")).click();;
		
			
			Thread.sleep(2000);
			
			driver.findElement(By.partialLinkText("3M 8511 Respirator")).click();;
		
			System.out.println(driver.findElement(By.cssSelector("#productTitle")).getText());
				
		
	}

}
