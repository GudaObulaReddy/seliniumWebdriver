package com.Selinium;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.netty.handler.codec.http.multipart.FileUpload;

public class JavaScriptScreenShot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
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
		drawBorder(element,driver);
		// take screen shot

		// now copy the screen shot to desired location
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C:\\Users\\Ramakrishna\\eclipse-workspace\\Selinium\\src\\com\\Selinium\\screenshot.png"));

	}
	public static void drawBorder(WebElement element,WebDriver driver)
	{
		JavascriptExecutor  js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		try
		{
			Thread.sleep(20);
			
		}catch(InterruptedException e)
		{
			
		}
	}

}
