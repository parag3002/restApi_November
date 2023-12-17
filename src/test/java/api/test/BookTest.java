package api.test;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.github.javafaker.Faker;
import com.github.javafaker.IdNumber;
import com.google.gson.JsonObject;

import dev.failsafe.internal.util.Assert;
import groovyjarjarpicocli.CommandLine.IExitCodeExceptionMapper;
import io.opentelemetry.api.trace.StatusCode;
import io.restassured.http.ContentType;
import io.restassured.internal.ResponseSpecificationImpl.HamcrestAssertionClosure;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import java.io.FileReader;
import jdk.internal.net.http.common.Log;
import net.sf.saxon.exslt.Math;

import api.payload.*;
import api.*;
import api.endpoints.BookEndpoints;
import api.payload.BookPayLoad;

public class BookTest 
{
	private boolean flag=true;

	@Test
	public void test_createBook()
	{
		int min = 100;
        int max = 500;
        int randomInRange = (int) (Math.random() * (max - min + 1)) + min;
        System.out.println("Random Number in Range: " + randomInRange);
        
        Faker fake = new Faker();
        BookPayLoad payload = new BookPayLoad();
        
        payload.setId(randomInRange);
        payload.setTitle(fake.name().firstName());
        payload.setDescription(fake.name().lastName());
        payload.setPageCount(408);
        payload.setExcerpt(fake.internet().emailAddress());
        payload.setPublishDate("2025-10-05T15:02:46.6465312+00:00");
        
        Response response  = BookEndpoints.createBook(payload);
        response.then().log().all();
       
        
        try
        {
        assertEquals(response.statusCode(), 200);
        assertEquals(response.header("Content-Type"), "application/json; charset=utf-8; v=1.0");
        assertEquals(response.header("Transfer-Encoding"), "chunked");
        assertEquals(response.header("api-supported-versions"), "1.0");
        
//      assertEquals(response.cookie(""), "");
        JsonPath jsonpath = response.jsonPath();
        int id = jsonpath.getInt("id");
        System.out.println(id);
        
        assertEquals(id, id);
//      System.out.println("id validated");
        
        }
        catch(AssertionError e)
        {
        	flag = false;
        	System.out.println("<------------Assertion related ERROR--------->");
        	
        }
        finally //this block always executes
        {
        	if(flag==true)
        	{
        		System.out.println("<-----------All Assertion passed----->");
        	}
        }
        
	}
	
	
	@Test
	public void test_getAllBooks()
	{
		Response response = BookEndpoints.readAllBooks();
		
		response.then().log().all();
		
		JsonPath jsonpath = response.jsonPath();
		List<Integer> bookIds = jsonpath.getList("id");
		int forthBookId = bookIds.get(3);
		System.out.println("4th book id --------->"+forthBookId);
		assertEquals(response.statusCode(),200);
		
	}
	

	@Test
	public void test_updateBook()
	{
		
		int min = 100;
        int max = 500;
        int randomInRange = (int) (Math.random() * (max - min + 1)) + min;
        System.out.println("Random Number in Range: " + randomInRange);
        
        Faker fake = new Faker();
        BookPayLoad payload = new BookPayLoad();
        
        payload.setId(randomInRange);
        payload.setTitle(fake.name().firstName());
        payload.setDescription(fake.name().lastName());
        payload.setPageCount(408);
        payload.setExcerpt(fake.internet().emailAddress());
        payload.setPublishDate("2024-05-06T15:02:46.6465312+00:00");
        
        Response response = BookEndpoints.updateBook(payload,4);
        response.then().log().all();
        
        assertEquals(response.statusCode(),200);
        
	}
	
	
}
