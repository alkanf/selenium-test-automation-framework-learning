package day1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDynamicDataIntoExcel {
//Excel file = Workbook → Sheets → Rows → Cells
//creating workbook and sheet
	public static void main(String[] args) throws IOException { // directory location as you will be creating new xlsx
																// file.
		XSSFWorkbook workbook = new XSSFWorkbook(); // pass file parametre at the end
		XSSFSheet sheet1 = workbook.createSheet("DynamicData");

//creating rows and cells with loop in order to dynamic with scanner class // you need to .setCellValue in order to give value.
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter how many rows do you want?");
		int numberOfrows = sc.nextInt();
		System.out.println("Enter how many cells do you want?");
		int numberOfcells = sc.nextInt();
		for (int row = 0; row <= numberOfrows; row++) {
			XSSFRow currentRow = sheet1.createRow(row);
			for (int cell = 0; cell < numberOfcells; cell++) {
				XSSFCell currentCell = currentRow.createCell(cell);
				currentCell.setCellValue(sc.next()); // not hardcoded, //sc.next not int as user can insert any datatype
			}
		}

		FileOutputStream file = new FileOutputStream(
				"C:\\Users\\alkan\\Selenium_Frameworks\\LearningSeleniumFramework\\testdata\\dynamicData.xlsx");
		workbook.write(file);

		workbook.close();
		file.close();
		sc.close();


		System.out.println("File is created");

	}

}
