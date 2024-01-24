import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Files.Payload;
import Files.ReusableMethods;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;

public class DynamicJson 
{
	@Test(dataProvider = "BooksData")
	public void addBook(String isbn, String aisle) {
	    RestAssured.baseURI = "http://216.10.245.166";
	    String resp = given().log().all().header("Content-Type", "application/json")
	            .body(Payload.addBook(isbn, aisle))
	            .when().post("/Library/Addbook.php")
	            .then().log().all().assertThat().statusCode(200)
	            .extract().response().asString();

	    JsonPath js = ReusableMethods.rawTojson(resp);
	    String id = js.get("ID");
	    System.out.println(id);
	}

	@DataProvider(name = "BooksData")
	public Object[][] getDat() {
		// array = collection of elements
		// Multidimensional array = collection of arrays
	    return new Object[][] {{"aaaa", "636367"}, {"bbbb", "8734"}, {"cccc", "7346"}, {"dddd", "83447"}};
	}
}
