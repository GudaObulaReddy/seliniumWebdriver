package com.Selinium;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentWait1 {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe");
		WebDriver driverObject1=new ChromeDriver();
		driverObject1.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driverObject1.findElement(By.xpath("//button[contains(text(),'Start')]")).click();
		if(driverObject1.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed())
			
		{
			driverObject1.findElement(By.xpath("//div[@id='finish']/h4")).getText();
		}
		else
		{
			System.out.println("not displayed");
		}
		
		Wait<WebDriver> waitObj1=new FluentWait<WebDriver>(driverObject1).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		WebElement webele1=waitObj1.until(new Function<WebDriver, WebElement>()
		{
			public WebElement apply(WebDriver driverObject1) 
			{
				if(driverObject1.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed())
				
				{
					return driverObject1.findElement(By.xpath("//div[@id='finish']/h4"));
				}
				
				else
				
					return null;
				
			
			}
		});
		System.out.println(webele1.getText());

	}

}
