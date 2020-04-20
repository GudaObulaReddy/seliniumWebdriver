package com.Selinium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapAnother {

	public static void main(String[] args) 
	{System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.google.com");
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://v4-alpha.getbootstrap.com/components/dropdowns/");
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//button[@id=\"dropdownMenuButton\"]")).click();
	List<WebElement> list=driver.findElements(By.xpath("//div[@class=\"dropdown-menu\" and @aria-labelledby=\"dropdownMenuButton\"]//a"));
	System.out.println(list.size());
	for(int i=0;i<list.size();i++)
	{
		System.out.println(list.get(i).getText());
		if(list.get(i).getText().equals("Another action"))
		{
			list.get(i).click();
			break;
		}
	}
		
	}

}
