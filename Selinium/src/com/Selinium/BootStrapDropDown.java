package com.Selinium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapDropDown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[contains(@class,\"multiselect\")]")).click();
		List<WebElement> list=driver.findElements(By.xpath("//ul[contains(@class,\"multiselect\")]//li//a//label"));
		System.out.println(list.size());
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("HTML"))
			{   if(list.get(i).isEnabled())
			{
				
			}
			else
			{
				list.get(i).click();
			}
			}
		}

	}

}
