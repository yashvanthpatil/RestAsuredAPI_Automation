import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*; // ***************this import manually we should add this********************

import java.io.File;

import org.testng.Assert;

public class JiraTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI = "http://localhost:8080";
		
		SessionFilter session = new SessionFilter(); // this class used to store the current session id 
		// this is an alternative way for extracting the values from jsonpath
		
// Login code
		given().header("Content-Type","application/json").body("{ \"username\": \"admin\", \"password\": \"admin\" }").log().all()
		.filter(session)
		.when().post("/rest/auth/1/session")
		.then().extract().response().asString();
		
		String expectedMessage = "Hi , How are you 2 ?";
		
		String AddCommentresp = given().pathParam("id", "10102").log().all().header("Content-Type","application/json").body("{\r\n"
				+ "    \"body\": \""+expectedMessage+"\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}")
		.log().all().filter(session)
		.when().post("/rest/api/2/issue/{id}/comment").then().assertThat().statusCode(201).extract().response().asString();
		
		// get the comment id from the response (11th lesson)
		JsonPath js = new JsonPath(AddCommentresp);
		String commentId = js.getString("id");
		
		// Added comment for the issue REST-2

		//************ Add attachment***************
		
		
		
		// to add file in rest api automation there is an on emethod called multi part in that we need to send an file
		// the above headders are taken frm the resource od ad attachment api in jira that is in the CURL command
		
//curl -D- -u admin:admin -X POST -H "X-Atlassian-Token: no-check" -F "file=@myfile.txt" http://myhost/rest/api/2/issue/TEST-123/attachments
		// Attached the jira.txt file in file class 
		given().header("X-Atlassian-Token", "no-check").filter(session).pathParam("Key", "10102")
		
		.header("content-type","multipart/form-data")// wheneve we are using multipart method then header will be content-type","multipart/form-data
		
		.multiPart("file", new File("Jira.txt")).when().post("/rest/api/2/issue/{Key}/attachments").then().log().all()
		.assertThat().statusCode(200);
		
		// Floder 8 , 9th lesson is completed

		// folder 8 , 10th lesson
		
		// get issue details
// Introducing path and query parameters		
		
	String issueDetails =	given().filter(session).pathParam("Key", "10102")
			.queryParam("fields", "comment")
			.log().all().when().get("/rest/api/2/issue/{Key}")
		.then().log().all().extract().response().asString();
	System.out.println("printing the get issue response     ======    "+issueDetails);
	
	// verifying the added comment is correct or not from the comment id ( comment is unique) lets check by iterating through each comments
	
	JsonPath js1 = new JsonPath(issueDetails);
		int commentsCount = js1.get("fields.comment.comments.size()");
		for(int i=0; i<commentsCount; i++)
		{
	
	//	System.err.println(js1.get("fields.comment.comments["+i+"].id"));	this will return the comment id's of each comment added in project
		String CommentIdIssues = js1.get("fields.comment.comments["+i+"].id");
		if(CommentIdIssues.equalsIgnoreCase(commentId))
		{
			String message = js1.get("fields.comment.comments["+i+"].body").toString();
			System.out.println(message);
			Assert.assertEquals(message, expectedMessage);

// ***********httpsrelaxedValidation******************* method to by pass the https authentications	
			// below is the example for this
			
	/*		given().relaxedHTTPSValidation().filter(session).pathParam("Key", "10102")
			.queryParam("fields", "comment")
			.log().all().when().get("/rest/api/2/issue/{Key}")
		.then().log().all().extract().response().asString();    
		
		*/
			
// Completed with the *******************8th folder 12th lesson*************************
			
		}
		}
	}
}




