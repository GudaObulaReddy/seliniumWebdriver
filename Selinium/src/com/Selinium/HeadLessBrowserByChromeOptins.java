package com.Selinium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLessBrowserByChromeOptins {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("window-size=1400,1800");
		options.addArguments("headless");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        System.out.println(driver.getTitle());
	}

}
