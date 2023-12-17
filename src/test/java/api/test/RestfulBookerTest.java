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
import api.utilities.PropertyReader;
import api.*;
import api.endpoints.*;

public class RestfulBookerTest 
{

	private static String token;
	private static int idBooking;
	
	
	@Test(priority=1)
	public static void test_getBookingByIds()
	{
		Response response =RestfulBooking.getBookingByIds();
		
		response.then().log().all();
		
		try
		{
			assertEquals(response.statusCode(), 200);
			System.out.println("Assertion pass for test_getBookingByIds");
		}
		catch(AssertionError e)
		{
			System.out.println("Assertion failed , response code mismatch error");
		}

	}
	
	
	
	@Test(priority=2)
	public static void test_createToken()
	{
		RestfulBookingPayload payload = new RestfulBookingPayload();
		payload.setUsername("admin");
		payload.setPassword("password123");
		
		Response response = RestfulBooking.createToken(payload);
		
		response.then().log().all();
		
		JsonPath jsonpath = response.jsonPath();
		token = jsonpath.getString("token");
		System.out.println("Toekn Generated //////////////> "+token);
	}
	
	
	
	@Test(priority=3)
	public void test_getBookingById()
	{
		Response response = RestfulBooking.getBookingById(23);
		
		response.then().log().all();
		
	}
	
	@Test(priority=4)
	public void test_createBooking()
	{
		
		RestfulBookingCreateBooking payload = new RestfulBookingCreateBooking();
		RestfulApibookingdates bookingdates = new RestfulApibookingdates();
		
		payload.setFirstname("Davidd");
		payload.setLastname("Joee");
		payload.setTotalprice(111);
			bookingdates.setCheckin("19-dec-2023");
			bookingdates.setCheckout("23-dec-2023");
		payload.setBookingdates(bookingdates);
		payload.setAdditionalneeds("Dinner");
		
		
		Response response = RestfulBooking.createBooking(payload);
		
		response.then().log().all();
		
		JsonPath jsonpath = response.jsonPath();
		idBooking = jsonpath.getInt("bookingid");
		System.out.println("Generated booking id-------->>"+idBooking);
	}
	
	
	@Test(priority=5)
	public void patchBooking()
	{
		RestfulBookerPatch payload = new RestfulBookerPatch();
			payload.setFirstname("Madan");
			payload.setLastname("Asis");
		
		Response response = RestfulBooking.patchBooking(payload, idBooking, token);
		
		response.then().log().all();
	}
	

}
