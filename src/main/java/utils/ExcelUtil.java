package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public static String TEST_DATA_SHEET = "./src/test/resources/testData/UsersData.xlsx";
	private static Workbook book;
	private static Sheet sheet;
	
	public static Object[][] getTestData (String sheetName) {
		
		Object data[][] = null;
		
		try {
			FileInputStream ip2 = new FileInputStream(TEST_DATA_SHEET);
			book = WorkbookFactory.create(ip2);
			sheet = book.getSheet(sheetName);
			
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			int rowcount = sheet.getLastRowNum();
			//System.out.println(rowcount);
			for (int i = 0; i < rowcount; i++) {	
				int cellcount = sheet.getRow(i).getLastCellNum();
				//System.out.println(cellcount);
				for (int j = 0; j < cellcount; j++) {
					String value = sheet.getRow(i+1).getCell(j).getStringCellValue();
					data[i][j] = sheet.getRow(i+1).getCell(j).getStringCellValue();
					//System.out.println(value);
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}
