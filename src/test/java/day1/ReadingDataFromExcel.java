package day1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {
//Excel file = Workbook → Sheets → Rows → Collumns
	public static void main(String[] args) throws IOException {
//Opening xlxss, workbook and sheet
FileInputStream file = new FileInputStream("C:\\Users\\alkan\\Selenium_Frameworks\\LearningSeleniumFramework\\testdata\\data.xlsx"); //hardcoded
XSSFWorkbook workbook = new XSSFWorkbook(file);
XSSFSheet sheet = workbook.getSheet("Data");

//Finding length // Cant retrieve cells, directly rows -> cells 
int totalRows = sheet.getLastRowNum(); //Length of rows = Number of rows
int totalCells = sheet.getRow(1).getLastCellNum(); //All cell numbers, can pass any row number
System.out.println("Total number of rows" + totalRows); System.out.println("Total number of columns" + totalCells);
//for loop for retrieving all rows then columns with nested for loop //rows start with 0 and columns starts with 1 <= // <
for(int row=0;row<=totalRows;row++) {
	XSSFRow currentRow = sheet.getRow(row);
	for(int column=0;column<totalCells;column++) {
		XSSFCell currentCell = currentRow.getCell(column);
		System.out.print(currentCell.toString()+"\t"); // int -> string for retrieving data, delete ln and print for same line order
	}
	System.out.println(); //jumping to next line
}
workbook.close();
file.close();


	
	
	
	
	}

}
