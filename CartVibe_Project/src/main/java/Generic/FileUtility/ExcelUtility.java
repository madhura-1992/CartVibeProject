package Generic.FileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String readDataFromExcel(String sheetName,int rowNum, int cellNum) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		String data=sh.getRow(rowNum).getCell(cellNum).getStringCellValue();
		System.out.println(data);
		return data;
	}
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		int rowCount=sh.getLastRowNum();
		wb.close();
		return rowCount;
	}
	public void writeDataToExcel(String sheetName,int rowNum, int cellNum, CellType cellType,String data) throws Throwable {
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Cell cell = wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum, cellType);
		cell.setCellValue(data);
		FileOutputStream fos=new FileOutputStream("./src/test/resources/TestData.xlsx");
		wb.write(fos);
		wb.close();
	}
}
