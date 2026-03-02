package day2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorAutomation2 {
	public static void main(String[] args) throws IOException {
//Opening
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
String pathFile = "C:\\Users\\alkan\\Selenium_Frameworks\\SeleniumFrameworks\\testdata\\caldata2.xlsx";
driver.findElement(By.id("onetrust-accept-btn-handler")).click(); //Accept Cookies 
//all row count 
int allRows = ExcelUtils.getRowCount(pathFile, "Sheet1");
//for loop
for(int row=1;row<=allRows;row++) {
//1) reading xml file and defining rows
String depAmount = ExcelUtils.getCellData(pathFile, "Sheet1", row, 0);
String intRate = ExcelUtils.getCellData(pathFile, "Sheet1", row, 1);
String length = ExcelUtils.getCellData(pathFile, "Sheet1", row, 2);
String compounding = ExcelUtils.getCellData(pathFile, "Sheet1", row, 3);
String expectedResult = ExcelUtils.getCellData(pathFile, "Sheet1", row, 4);
//2) Application
driver.findElement(By.id("mat-input-0")).clear();
driver.findElement(By.id("mat-input-0")).sendKeys(depAmount);
driver.findElement(By.id("mat-input-2")).clear();
driver.findElement(By.id("mat-input-2")).click(); //Click again as intRate dom 
driver.findElement(By.id("mat-input-2")).sendKeys(intRate);
driver.findElement(By.id("mat-input-1")).clear();
driver.findElement(By.id("mat-input-1")).sendKeys(length);
//Dynamic Dropdown and explicit wait
driver.findElement(By.id("mat-select-0")).click();
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement option = wait.until(
    ExpectedConditions.elementToBeClickable(
        By.xpath("//mat-option//span[normalize-space()='" + compounding + "']") ));
option.click();

driver.findElement(By.id("CIT-chart-submit")).click(); // dont forget to click
String actualResult = driver.findElement(By.id("displayTotalValue")).getText();

//3)Validation
if (expectedResult.trim().equals(actualResult.trim())) {
	System.out.println("Test Case is validated");
	ExcelUtils.setCellData(pathFile, "Sheet1", row, 6, "Passed");
	ExcelUtils.fillGreenColor(pathFile, "Sheet1", row, 6);
} else {
	System.out.println("Test Case is not validated");
	ExcelUtils.setCellData(pathFile, "Sheet1", row, 6, "Failed");
	ExcelUtils.fillRedColor(pathFile, "Sheet1", row, 6);
}

	}
driver.quit();
	}
}
