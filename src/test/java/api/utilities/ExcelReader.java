package api.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{

	private FileInputStream file;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private XSSFRow row;
	
	ExcelReader()
	{
		try
		{
			file = new FileInputStream(".\\src\\test\\resources\\Userdata.xlsx");
			workbook = new XSSFWorkbook(file);
		}
		catch(IOException e)
		{
			System.out.println("File not found");
		}
	}
	
	
	public void readExcel()
	{
		
		sheet = workbook.getSheet("booking_data");
		row = sheet.getRow(0);
		
		String celdata = row.getCell(0).getStringCellValue();
		
		System.out.println(celdata);
		
		
	}
	
	
	
// For Debug ==========================================================
	public static void main(String args[])
	{
		ExcelReader excel = new ExcelReader();
		
		excel.readExcel();
		
	}
//=====================================================================
	
}
