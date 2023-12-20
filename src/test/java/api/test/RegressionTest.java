package api.test;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;

import javax.validation.Payload;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import api.endpoints.Regression;
import api.payload.RegressionPayload;
import api.utilities.PropertyReader;
import io.opentelemetry.api.trace.StatusCode;
import io.restassured.internal.support.FileReader;
import io.restassured.response.Response;

public class RegressionTest 
{

	@Test(priority=1)
	public void testGetStatusCode()
	{
		Response response =  Regression.getStatusCodeVerify();
		response.then().log().all();
		
		try
		{
			assertEquals(response.statusCode(), 200);
			System.out.println("Assertion Pass");
		}
		catch(AssertionError e)
		{
			System.out.println(e);
		}
		
	}
	
	JSONObject jsonObject;
	
	// post request using exxternal file
	@Test(priority=2)
	public void testJsonSchemaVerify()
	{

		try
		{
			File jsonFile = new File(PropertyReader.readProperties("jsonPath"));
			java.io.FileReader reader = new java.io.FileReader(jsonFile);
			
			JSONTokener jsonToken = new JSONTokener(reader); // from org.json package
			this.jsonObject = new JSONObject(jsonToken); // from org.json package
			
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}

		System.out.println(jsonObject.toString());
		
		Response response = Regression.JSONschemaVerification(jsonObject.toString());
		
		response.then().log().all();
		
		
	}
}
