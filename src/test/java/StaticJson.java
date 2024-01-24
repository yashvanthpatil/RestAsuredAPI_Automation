import static io.restassured.RestAssured.given;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import Files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class StaticJson 
{
	@Test
	public void addBook() throws Throwable {
	    RestAssured.baseURI = "http://216.10.245.166";
	    // passing the data fom external file
	    String resp = given().log().all().header("Content-Type", "application/json")
	            .body(generatetringFromResource("Y:\\Yashvanth patil learnings\\addBooks.json"))
	            .when().post("/Library/Addbook.php")
	            .then().log().all().assertThat().statusCode(200)
	            .extract().response().asString();

	    JsonPath js = ReusableMethods.rawTojson(resp);
	    String id = js.get("ID");
	    System.out.println(id);
	}
//	7th folder **********8th lesson********
	// static json files(payload) directl into pst methd od rest assured
	
	public  String generatetringFromResource(String path) throws Throwable 
	{
		return new String(Files.readAllBytes(Paths.get(path)));
	}

}

	// 1. Login to jira to create session using Login API

	// 2. Add a comment to existing issue and Add comment API

	// 3. Add an attachment to existing issue using Add Attachment API
	
	// 4. Get issue details and verify id added comment and attachment exists using get issue API.

	// moving to new class i.e jiratest


