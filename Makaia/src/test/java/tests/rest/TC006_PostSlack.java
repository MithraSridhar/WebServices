package tests.rest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import lib.rest.RESTAssuredBase;


public class TC006_PostSlack extends RESTAssuredBase{

	@BeforeTest
	public void setValues() {

		testCaseName = "Create a new Incident";
		testDescription = "Login, Create a new Incident and Logout";
		nodes = "Incident";
		authors = "Babu";
		category = "smoke";
		dataFileName = "TC001";
		dataFileType = "JSON";
	}

	@Test
	public void createIncident() {		
		 Map<String,String> authmap = new HashMap<String, String>();
			authmap.put("Authorization", "Basic bWl0aHVnb3BhbDMwQGdtYWlsLmNvbTpNSVRIVXNyaTEzMDcq");
			
		Response responseget = RestAssured
				.given()
				.headers(authmap)
			
				.log().all()	
				.pathParam("issueid","WEEK-7")				
				.get("https://webservicestraining.atlassian.net/rest/api/3/issue/{issueid}");
		
		responseget.prettyPrint();
		String	issueDescription;
		String	issueUrgency;
		String	issueAssignee;
		issueDescription = RESTAssuredBase.getContentWithKey(responseget, "fields.issuetype.description");
		issueUrgency = RESTAssuredBase.getContentWithKey(responseget, "fields.priority.id");
		issueAssignee = RESTAssuredBase.getContentWithKey(responseget, "fields.assignee");
		System.out.println("Issue description is" +issueDescription);
		System.out.println("Issue urgency is" +issueUrgency);
		System.out.println("Issue assignee is" +issueAssignee);
		System.out.println(RESTAssuredBase.getContentWithKey(responseget,"fields.description.content.text"));
		System.out.println(RESTAssuredBase.getContentWithKey(responseget,"fields.project.id"));
		System.out.println(RESTAssuredBase.getContentWithKey(responseget,"fields.project.key"));
		
		System.out.println(RESTAssuredBase.getContentWithKey(responseget,"fields.creator.emailAddress"));
	}


}





