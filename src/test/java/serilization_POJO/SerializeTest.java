package serilization_POJO;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;

public class SerializeTest {

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
		
		List<String> myList = new ArrayList<String>();
		myList.add("show1");
		myList.add("show2");
		p.setTypes(myList);
		
		Location l = new Location();
		l.setLng(-00.383494);
		l.setLat(00.427362);
		p.setLocation(l);
		String resp = given().log().all().queryParam("key", "qaclick123")
		.body(p)
		.when()
		.post("/maps/api/place/add/json")
		.then().log().all()
		.assertThat().statusCode(200)
		.extract().response()
		.asString();
		System.out.println(resp);
	}

}


 