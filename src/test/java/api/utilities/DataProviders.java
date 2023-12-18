package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders 
{

	@DataProvider(name="AllData")
	public String[][] getAllData() throws Exception
	{

		int rowCount , colCount;
		String path = PropertyReader.readProperties("excelUtility_path");
		ExcelUtility excelFile = new ExcelUtility(path);
		
		rowCount = excelFile.getRowCount(PropertyReader.readProperties("sheetNameRestfulBooking"));
		colCount = excelFile.getCellCount(PropertyReader.readProperties("sheetNameRestfulBooking"), 1);
		
		String apiData[][]=new String[rowCount][colCount];
		
		for(int i=1;i<=rowCount;i++) 
		{
			for(int j=0; j<colCount;j++)
			{
				apiData[i-1][j]=excelFile.getCellData(PropertyReader.readProperties("sheetNameRestfulBooking"), i, j);
			}
		}
		
//////////////////////Additional part starts
		System.out.println("");
		System.out.println("================PRINTING ALL DATA FROM EXCEL============================");
		System.out.println(rowCount+"<--row-|-col-->"+colCount);
		
		for(int i=1;i<=rowCount;i++) 
		{
			for(int j=0; j<colCount;j++)
			{
				System.out.print(apiData[i-1][j]+" | ");
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("=====================END=======================");
//////////////////////Additional part end
		
		return apiData;
		
	}

/////////////for debug purpose
	public static void main(String args[]) throws Exception
	{
		DataProviders r = new DataProviders();
		r.getAllData();
		
	}
	
//-----------------------------------------
	
	

	
	
}
