package day2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalculatorAutomation {

	public static void main(String[] args) throws IOException, InterruptedException {
//First Application then handling excel file
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testsheepnz.github.io/BasicCalculator.html");
//can create variable for path 
		String calculatorData = "C:\\Users\\alkan\\Selenium_Frameworks\\LearningSeleniumFramework\\testdata\\caldata.xlsx";
//for defining loop multiple tests, we need to learn how many rows
		int allRows = ExcelUtils.getRowCount(calculatorData, "Sheet2");
//get cell with method in row(i) loop, start from 1 as we dont need header as test case
		for (int row = 1; row <= allRows; row++) {
//1) Read data from excel (including exp result) 	
			String firstNumber = ExcelUtils.getCellData(calculatorData, "Sheet2", row, 0);
			String secondNumber = ExcelUtils.getCellData(calculatorData, "Sheet2", row, 1);
			String operation = ExcelUtils.getCellData(calculatorData, "Sheet2", row, 2);
			String expectedResult = ExcelUtils.getCellData(calculatorData, "Sheet2", row, 3);

			// 2) Pass above data into application (Only use string format)
			driver.findElement(By.name("number1")).sendKeys(firstNumber);
			driver.findElement(By.name("number2")).sendKeys(secondNumber);
			Select selOp = new Select(driver.findElement(By.name("selectOperation")));
			selOp.selectByVisibleText(operation);
			driver.findElement(By.id("calculateButton")).click(); // dont forget to click

			// 3) Validation (change string to numbers as we are dealing with numeric),
			// comparing and updating last cell with setCellData
			String actualResult = driver.findElement(By.id("numberAnswerField")).getAttribute("value");
			if (Double.parseDouble(expectedResult) == Double.parseDouble(actualResult)) {
				System.out.println("Test Case is validated");
				ExcelUtils.setCellData(calculatorData, "Sheet2", row, 5, "Passed");
				ExcelUtils.fillGreenColor(calculatorData, "Sheet2", row, 5);
			} else {
				System.out.println("Test Case is not validated");
				ExcelUtils.setCellData(calculatorData, "Sheet2", row, 5, "Failed");
				ExcelUtils.fillRedColor(calculatorData, "Sheet2", row, 5);
			}
			driver.findElement(By.id("clearButton")).click(); // dont forget to reset execution
			driver.findElement(By.name("number1")).clear();
			driver.findElement(By.name("number2")).clear();

		}
		driver.quit();
	}

}
