package com.Selinium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeProfiling {

	public static void main(String[] args) throws InterruptedException {
		DesiredCapabilities  profile=new DesiredCapabilities();
		profile.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

		profile.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		ChromeOptions options=new ChromeOptions();
		options.merge(profile);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://badssl.com/");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()=\"expired\"]")).click();
		

	}

}
