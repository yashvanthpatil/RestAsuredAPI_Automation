package Files;

import io.restassured.path.json.JsonPath;

public class ReusableMethods {

	public static JsonPath rawTojson(String response) {
		// TODO Auto-generated method stub
		JsonPath js1 = new JsonPath(response);
		return js1;
	}

}
