package in.licious.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import in.licious.BannersTestCases.BaseTest;

public class ReadExcelData extends BaseTest{
	public static final String Test_Sheet_Data =System.getProperty("user.dir")+properties.getProperty("ExcelFilePath");
	
	static Workbook Book;
	static Sheet sheet;
	
	
	
	
	public synchronized  Map<String, String> getheaderinfo(String sheet_path, String testcasename)
			throws IOException {
		FileInputStream file = null;
		
		int flag = 0;
		Map<String, String> header = new HashMap<String, String>();

		file = new FileInputStream(Test_Sheet_Data);

		Book = new XSSFWorkbook(file);
		sheet = Book.getSheet(sheet_path);

		int lastRowNum = sheet.getLastRowNum();

		for (int i = 1; i <= lastRowNum; i++) {

			int lastCellNum = sheet.getRow(i).getLastCellNum();
			
			if (sheet.getRow(i).getCell(0).toString().equals(testcasename)) {
			
				for (int j = 2; j <=lastCellNum-1; j++) {
					if (sheet.getRow(i).getCell(j).toString()!="") {
						
						
						header.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i).getCell(j).toString());
						
						flag=1;
					}

				}

			}
			if (flag == 1)
				break;

		}
		
		
		file.close();
		Book.close();
		return header;

	}

	


}
