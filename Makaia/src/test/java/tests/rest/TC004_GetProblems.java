package tests.rest;

import java.io.File;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;


public class TC004_GetProblems extends RESTAssuredBase{

	@BeforeTest
	public void setValues() {

		testCaseName = "Get All Problems From Serivce now";
		testDescription = "Login, Get All Problems From Serivce now and Logout";
		nodes = "Problem";
		authors = "Mithra";
		category = "smoke";
		dataFileName = "TC004";
		dataFileType = "JSON";
	}

	//@Test(dataProvider = "fetchData")
	@Test
	public void getProblems() {		
		
		// Post the request
		Response response =  get();
		
		//Verify the Content by Specific Key
		//verifyContentWithKey(response, "result.short_description", "This is Rest Assured Automation framework - Makaia");
		
		// Verify the Content type
		verifyContentType(response, "JSON");
		
		// Verify the response status code
		verifyResponseCode(response, 200);	
		
		// Verify the response time
		verifyResponseTime(response, 15000);
		
	}


}





