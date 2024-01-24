import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;  // manualy added 
import Files.Payload;
import Files.ReusableMethods;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

// validate if add place Api is working as expected
		
		//given - all input details
		//when - submit the api
		//then - validate the response
		
	RestAssured.baseURI = "https://rahulshettyacademy.com";
	String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
	.body(Payload.Addplace()).when().post("/maps/api/place/add/json")
	.then().assertThat().statusCode(200).body("scope", equalTo("APP"))
	.header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
	
	System.out.println(response);
	JsonPath js = new JsonPath(response);   // to parse the json to string
	String placeid = js.getString("place_id");
	
	System.out.println("place id is = " + placeid);
	// ***** 5th folder 3rd lesson completed
	
	String newadess = "Summer walk, USA";
	
	given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
	.body("{\r\n"
			+ "\"place_id\":\""+placeid+"\",\r\n"
			+ "\"address\":\""+newadess+"\",\r\n"
			+ "\"key\":\"qaclick123\"\r\n"
			+ "}\r\n"
			+ "").when().put("/maps/api/place/update/json").then().assertThat().log().all()
		.statusCode(200).body("msg", equalTo("Address successfully updated"));
	
		// update adress completed *** 5th folder 4th lesson ***
	
	//get place
	
String getplaceresponse =	given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid)
	.when().get("maps/api/place/get/json").then().assertThat().log().all()
	.statusCode(200).extract().response().asString();
	
	
	JsonPath js1 = ReusableMethods.rawTojson(getplaceresponse);
	String actualaddress = js1.getString("address");
	System.out.println(actualaddress);
	
	// ***** 5th folder ****** 5th lesson completed *******
	// 5th folder *******6th lesson******** 
	Assert.assertEquals(actualaddress, newadess);
	Assert.assertEquals(actualaddress, "yashvanth patil wrong address");
	
	// 6th folder ********1st and 2nd lesson********
	
//	1. Print No of courses returned by API
//	2.Print Purchase Amount
//	3. Print Title of the first course
//	4. Print All course titles and their respective Prices
//	5. Print no of copies sold by RPA Course
//	6. Verify if Sum of all Course prices matches with Purchase Amount
	
//	moved to ********* ComplexJsonParse class ***********
	
	}

}
