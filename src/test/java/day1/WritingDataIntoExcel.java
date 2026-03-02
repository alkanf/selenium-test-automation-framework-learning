package day1;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcel {
//Excel file = Workbook → Sheets → Rows → Cells
//creating workbook and sheet
	public static void main(String[] args) throws IOException { //directory location as you will be creating new xlsx file.
XSSFWorkbook workbook = new XSSFWorkbook(); //pass file parametre at the end
XSSFSheet sheet1 = workbook.createSheet("Data");

//creating rows and for each rows we are creating cells. // you need to .setCellValue in order to give value.
XSSFRow row1 = sheet1.createRow(0);
row1.createCell(0).setCellValue("Adam");
row1.createCell(1).setCellValue("18");
row1.createCell(2).setCellValue("YES");

XSSFRow row2 = sheet1.createRow(1);
row2.createCell(0).setCellValue("Eve");
row2.createCell(1).setCellValue("15");
row2.createCell(2).setCellValue("NO");

XSSFRow row3 = sheet1.createRow(2);
row3.createCell(0).setCellValue("Ethan");
row3.createCell(1).setCellValue("32");
row3.createCell(2).setCellValue("YES");

FileOutputStream file = new FileOutputStream("C:\\Users\\alkan\\Selenium_Frameworks\\SeleniumFrameworks\\testdata\\data.xlsx"); 
workbook.write(file);

workbook.close();
file.close();

System.out.println("File is created");








	}

}
