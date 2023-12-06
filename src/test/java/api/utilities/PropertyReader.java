package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



public class PropertyReader 
{

	private static FileInputStream propertyFile;
	private static Properties property;
	

	
	public static String readProperties(String s)
	{
		
		String fileData;
		try
		{
		propertyFile = new FileInputStream("C:\\E\\workspaces\\workSpace_RestAssured_P1\\restApi_November\\src\\test\\resources\\routes.properties");
		property = new Properties();
			 
		property.load(propertyFile);
		}
		catch(IOException e) {}
		
		fileData = property.getProperty(s);
		
		return fileData;
	}
	
	
//	public static void main(String args[])
//	{
//		
//		System.out.println(readProperties("route1"));
//	}
}
