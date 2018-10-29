package tests.rest;

import java.io.File;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;


public class TC003_CreateChangeRequest extends RESTAssuredBase{

	@BeforeTest
	public void setValues() {

		testCaseName = "Create a new Change Request";
		testDescription = "Login, Create a new Change request and Logout";
		nodes = "Change";
		authors = "Mithra";
		category = "smoke";
		dataFileName = "TC003";
		dataFileType = "Excel";
	}

	@Test(dataProvider = "fetchData")
public void createIncident(String myDescription) {		
		
		// Post the request
		Response response = postWithJsonAsBody("{\"description\":\""+ myDescription+"\"","");
		response.prettyPrint();
		//Verify the Content by Specific Key
		verifyContentWithKey(response, "result.description", myDescription);
		//verifyContentWithKey(response, "result.short_description", "This is Rest Assured Automation framework - Makaia");
		
		// Verify the Content type
		verifyContentType(response, "JSON");
		
		// Verify the response status code
		verifyResponseCode(response, 201);	
		
		// Verify the response time
		verifyResponseTime(response, 50000);
		
	}
	/*public void createIncident(String jsonObject) {		
		
		// Post the request
		Response response = postWithJsonAsBody(jsonObject,"");
		
		response.prettyPrint();
		
		//Verify the Content by Specific Key
		verifyContentWithKey(response, "result.short_description", "This is Rest Assured Automation framework - Makaia");
		
		// Verify the Content type
		verifyContentType(response, "JSON");
		
		// Verify the response status code
		verifyResponseCode(response, 201);	
		
		// Verify the response time
		verifyResponseTime(response, 10000);
		
		//Get key of created issue
		getContentWithKey( response, "result.number");
		
	}*/


}





