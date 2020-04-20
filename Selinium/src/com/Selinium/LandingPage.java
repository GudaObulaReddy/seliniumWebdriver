package com.Selinium;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LandingPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();

		driver.get("https://www.spicejet.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// Clicking on round Trip
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		Thread.sleep(4000);
		// Clicking back to One Way
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXTaction")).click();
		// Choosing Chennai in From
		driver.findElement(By.xpath("//a[@text='Chennai (MAA)']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#glsctl00_mainContent_ddl_destinationStation1_CTNR [text='Delhi (DEL)']"))
				.click();
		// #flightSearchContainer>.picker-first2>button css
		Thread.sleep(3000);
		
		List<WebElement> elementDates = driver.findElements(By.cssSelector(".ui-state-default"));
		int size = elementDates.size();
		/*
		// For check whether we are able to click on any available date
		String checkDate = "31";

		for (int i = 0; i < size; i++) {
			if (elementDates.get(i).getText().equalsIgnoreCase(checkDate)) {
				elementDates.get(i).click();
				break;
			}

		}
		*/
		
		/*
		// For checking if we are able to click on current date
		WebElement elementCurrDate = driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight"));
		elementCurrDate.click();
		*/

		// For selecting date in a specific month and Year
		String checkMonth = "December";
		String checkDate = "15";
		List<WebElement> elementMonths = driver.findElements(By.cssSelector(".ui-datepicker-title .ui-datepicker-month"));

		// Restricting dates to first table only
		List<WebElement> eleDateTab1 = driver
				.findElements(By.cssSelector(".ui-datepicker-group.ui-datepicker-group-first .ui-state-default"));
		int size2 = eleDateTab1.size();
		// Restricting dates to Second table only
		List<WebElement> eleDateTab2 = driver
				.findElements(By.cssSelector(".ui-datepicker-group.ui-datepicker-group-last .ui-state-default"));
		int size3 = eleDateTab2.size();
		// Checking if the month and date are available as part of the first table
		if (elementMonths.get(0).getText().contains(checkMonth)) {
			for (int i = 0; i < size2; i++) {
				if (eleDateTab1.get(i).getText().equalsIgnoreCase(checkDate)) {
					eleDateTab1.get(i).click();
					break;
				}

			}

		}
		// Checking if the month and date are available as part of the second table
		else if (elementMonths.get(1).getText().contains(checkMonth)) {
			for (int i = 0; i < size3; i++) {
				if (eleDateTab2.get(i).getText().equalsIgnoreCase(checkDate)) {
					eleDateTab2.get(i).click();
					break;
				}

			}
		}
		// Moving right to fetch the correct date in month
		else {
			while (!driver.findElements(By.cssSelector(".ui-datepicker-title .ui-datepicker-month")).get(1).getText()
					.contains(checkMonth)) {
				driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")).click();
				Thread.sleep(3000);
			}
			Thread.sleep(3000);
			int size4 = driver
					.findElements(By.cssSelector(".ui-datepicker-group.ui-datepicker-group-last .ui-state-default"))
					.size();
			for (int i = 0; i < size4; i++) {
				if (driver
						.findElements(By.cssSelector(".ui-datepicker-group.ui-datepicker-group-last .ui-state-default"))
						.get(i).getText().equalsIgnoreCase(checkDate)) {
					driver.findElements(
							By.cssSelector(".ui-datepicker-group.ui-datepicker-group-last .ui-state-default")).get(i)
							.click();
					break;
				}

			}
		}}}