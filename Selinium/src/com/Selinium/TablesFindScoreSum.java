package com.Selinium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TablesFindScoreSum {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Ramakrishna\\Desktop\\chromedriver\\chromedriver.exe");
		WebDriver driverObject1 = new ChromeDriver();
		driverObject1.get(
				"https://www.cricbuzz.com/live-cricket-scorecard/22773/nz-vs-ind-1st-t20i-india-tour-of-new-zealand-2020");
		driverObject1.manage().window().maximize();
		driverObject1.manage().deleteAllCookies();
		driverObject1.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driverObject1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		/*
		 * WebElement inningsNew=driverObject1.findElement(By.
		 * xpath("(//*[@class='cb-col cb-col-100 cb-ltst-wgt-hdr'])[1]"));
		 * 
		 * List<WebElement> runs=inningsNew.findElements(By.cssSelector(
		 * ".cb-col.cb-col-8.text-right.text-bold"));
		 * 
		 * int z=runs.size();
		 * 
		 * //Check for the items using console System.out.println(z); for(int
		 * i=0;i<z;i++) { System.out.println(runs.get(i).getText()); }
		 * 
		 * 
		 * int finalValue=0; for (int i=1;i<z-1;i++) { String
		 * Sum=runs.get(i).getText();//30 is returned and passed as string int
		 * finalSum=Integer.parseInt(Sum);//30 becomes a integer
		 * finalValue=finalValue+finalSum;//30 gets added to value 0 and stored
		 * infinalValue } int checkSum=Integer.parseInt(runs.get(z-1).getText());
		 * 
		 * if(checkSum==finalValue) { System.out.println("Test Case Pass"); } else {
		 * System.out.println("Test Case Fail"); }
		 * 
		 */
		// Handling the same in a Table format
				WebElement element1 = driverObject1.findElement(By.cssSelector("#innings_2>.cb-col.cb-col-100.cb-ltst-wgt-hdr:nth-child(1)"));
				List<WebElement> rowsInd = element1.findElements(By.cssSelector(".cb-col.cb-col-100.cb-scrd-itms>div:nth-child(3)"));
				int size1 = rowsInd.size();

				
				  //Check details of working 
				 
		/*
		 * for(int t1=0;t1<size1;t1++) { //For Choosing next column
		 * //System.out.println(rowsInd.get(t1).findElement(By.cssSelector(
		 * ".cb-col.cb-col-100.cb-scrd-itms>div:nth-child(4)")).getText()); //Choosing
		 * the bolded column
		 * System.out.println(rowsInd.get(t1).findElement(By.cssSelector(
		 * ".cb-col.cb-col-8.text-right.text-bold")).getText()); }
		 */
				int FinalScore = 0;

				for (int j = 0; j < size1 - 2; j++) {
					System.out.println(rowsInd.get(j).getText());
					String Sum1 = rowsInd.get(j).getText();
					int ScoreSum = Integer.parseInt(Sum1);
					FinalScore = FinalScore + ScoreSum;

				}

				int Extras = Integer.parseInt(
						driverObject1.findElement(By.xpath("(//div[text()='Extras']/following-sibling::div[1])[2]")).getText());
				// Parsing the Total value as a integer
				System.out.println(Extras);
				FinalScore = FinalScore + Extras;

				int CheckScore1 = Integer.parseInt(
						driverObject1.findElement(By.xpath("(//div[text()='Total']/following-sibling::div[1])[2]")).getText());
				System.out.println(CheckScore1);
				if (CheckScore1 == FinalScore) {
					System.out.println("Test Case Pass");
				} else {
					System.out.println("Test Case Fail");
				}


	}

}
