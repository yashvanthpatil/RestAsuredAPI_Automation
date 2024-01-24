package SpecBuilder;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import serilization_POJO.AddPlace;
import serilization_POJO.Location;

public class SpecBuilderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		AddPlace p = new AddPlace();
		p.setAccuracy(47);
		p.setName("heyheyheyheyhey");
		p.setAddress("0001111, pakkad layout, cholebature 03");
		p.setPhone_number("(+91) 666 222 1111");
		p.setWebsite("ww.go.com");
		p.setLanguage("kannada");
// ***************************************************************************************************	
		List<String> myList = new ArrayList<String>();
		myList.add("show1");
		myList.add("show2");
		p.setTypes(myList);
// *************************************************************************************************	
		Location l = new Location();
		l.setLng(-00.383494);
		l.setLat(00.427362);
		p.setLocation(l);
		
//		String resp = given().log().all().queryParam("key", "qaclick123")
//		.body(p)
//		.when()
//		.post("/maps/api/place/add/json")
//		.then().log().all()
//		.assertThat().statusCode(200)
//		.extract().response()
//		.asString();
//		System.out.println(resp);
// 13th folder 2nd lesson **************************** this is modified from serializationtest class
		
	RequestSpecification specreq	= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key","qaclick123")
			.setContentType(ContentType.JSON).build();
	
	ResponseSpecification specresp = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	// the above spec builders are generic data which used commonly/repetadly
	
		RequestSpecification request = given().spec(specreq).body(p); // this is part of request specification details for the request to send
		
		// then in addition to that request
		
		Response response = request.when().post("/maps/api/place/add/json").then().spec(specresp).extract().response();
		
		String responseValue = response.asString();
		System.out.println(responseValue);
		
		
		
// ********************************************************************************************************		
	
		// this is downloaded from resource of rahulshetty academy (****below code**)
	
//	RequestSpecification req =new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
//			.setContentType(ContentType.JSON).build();
//			 
//			 
//			ResponseSpecification resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
//			RequestSpecification res=given().spec(req)
//			.body(p);
//
//			Response response =res.when().post("/maps/api/place/add/json").
//			then().spec(resspec).extract().response();
//
//			String responseString=response.asString();
//			System.out.println(responseString);

	
	}

}


 