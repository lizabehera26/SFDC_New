import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class getExcelData {
	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet ;
	
public static String SheetPath = "C:\\SFDC_New\\TestNG_Project\\src\\Excel\\ExcelData.xlsx"	;
 
public static Object[][] getCredentialData(String sheetName)
		{
		FileInputStream file = null ;
		try
		{
			file = new FileInputStream(SheetPath);
			
		}catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
	            for(int i =0;i<sheet.getLastRowNum();i++) {
	            	for(int j=0;j< sheet.getRow(0).getLastCellNum();j++) {
	            		data[i][j] = sheet.getRow(i+1).getCell(j).toString();
	            	}
	            }
	            return data;
		  }
}
