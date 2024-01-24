package Plain_Old_Java_Object_POJO;
//import static io.restassured.RestAssured.*;

//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import io.restassured.path.json.JsonPath;
//public class oAuthTest {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.get(DEFAULT_URI);
//		// To extract the client secrate we use selenum web automation to login to the google account when signinusing google account
//		
//		
//		String accessTokenResponse = given()
//		.queryParams("code", "")
//		.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
//		.queryParams("client_secrate", "erZOWM9g3UtwNRj340YYaK_W")
//		.queryParams("redirect_uri" , "https://rahulshettyacademy.com/getCourse.php")
//		.queryParams("grant_type", "authorization_code")
//		.when().log().all()
//		.post("https://www.googleapis.com/oauth2/v4/token").asString();
//		
//		JsonPath js = new JsonPath(accessTokenResponse);
//		String accessToken = js.getString("access_token");
//		
//		
//		
//	String oAuthResp =	given().queryParam("access_token", accessToken).when()
//		.get("https://rahulshettyacademy.com/getCourse.php").asString();
//		
//	System.out.println(oAuthResp);
//	}
//
//}

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import io.restassured.parsing.Parser;

public class oAuthTestFor_POJO {

	public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

//String url ="https://rahulshettyacademy.com/getCourse.php?state=verifyfjdss&code=4%2FvAHBQUZU6o4WJ719NrGBzSELBFVBI9XbxvOtYpmYpeV47bFVExkaxWaF_XR14PHtTZf7ILSEeamywJKwo_BYs9M&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&session_state=0c32992f0d47e93d273922018ade42d1072b9d1f..a35c&prompt=none#";
//
//
//
//String partialcode=url.split("code=")[1];
//
//String code=partialcode.split("&scope")[0];
//
//System.out.println(code);
//
//
//// this will cancle the encoding process in the string which is passed as code in the response value
//String response =
//
//                given() 
//
//                .urlEncodingEnabled(false)
//
//                       .queryParams("code",code)
//
//               
//
//                   .queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
//
//                        .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
//
//                        .queryParams("grant_type", "authorization_code")
//
//                        .queryParams("state", "verifyfjdss")
//
//                        .queryParams("session_state", "ff4a89d1f7011eb34eef8cf02ce4353316d9744b..7eb8")
//
//                     // .queryParam("scope", "email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email")
//
//                       
//
//                        .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
//
//                        .when().log().all()
//
//                        .post("https://www.googleapis.com/oauth2/v4/token").asString();
//
//// System.out.println(response);
//
//JsonPath jsonPath = new JsonPath(response);
//
//    String accessToken = jsonPath.getString("access_token");
//
//    System.out.println(accessToken);
//
////String r2=    given().contentType("application/json").
//
////queryParams("access_token", accessToken).expect().defaultParser(Parser.JSON) // 
////
////.when()
////
////           .get("https://rahulshettyacademy.com/getCourse.php")
////
////.asString();
		
// this is the deserilization of json respone from code
		
		String[] coursetitlesvalidate = {"Selenium Webdriver Java","Cypress","Protractor"};

		String accessToken = "ya29.a0AfB_byAfosdM2GIhPS1kq_svoS_KDMEN1F97qW1SFazRy8VCLA_NpqfAIrMgplJ4HemXlNqfODTkWe9yw1ug52zy9jCXHKWC9smoiRN9fcQIyXyDWT7_mdfK2lwFn8M"
				+ "MHHcqnlqHZDhL_zWejn-h8CEb8JoqdvPhKUS_aCgYKAdwSARMSFQHGX2MiMhac8kJ5BB1pR13CHkgo5g0171";
// access code is taken from browser 
// not able to automate so manually pasting it in an string

		GetCourse r2 = given().log().all().contentType("application/json").queryParams("access_token", accessToken)
				.expect().defaultParser(Parser.JSON).log().all().when()
				.get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);

// the response of r2 will be stored in pojo class where the nested json is classified
// if we have content type as aplication/json in response header then no need to add .defaultParser(Parser.JSON) this in line 117
//System.out.println(r2);

		System.out.println(r2.getUrl());
		System.out.println(r2.getExpertise());
		System.out.println(r2.getInstructor());
		System.out.println(r2.getServices());
		System.out.println(r2.getLinkedIn());
		System.out.println(r2.getCourses().getApi().get(1).getCourseTitle());
		
		// To identify the course names and its prices dynamically based on course titles
		
		List<Api> apiCourses = r2.getCourses().getApi();
		for(int apiC=0; apiC<apiCourses.size(); apiC++)
		{
			if(apiCourses.get(apiC).getCourseTitle().equalsIgnoreCase("Rest Assured Automation using Java"))
			{
				System.out.println(apiCourses.get(apiC).getPrice());
			}
		}
			ArrayList<String> a = new ArrayList<>(); // for dynamically declaring the variables or its values we use array list
		
			
			List<webAutomation> webautoCourses = r2.getCourses().getWebAutomation();
			for(int webauto=0; webauto<webautoCourses.size(); webauto++)
			{
				a.add(webautoCourses.get(webauto).getCourseTitle());
//				a.add(webautoCourses.get(webauto).getPrice());
			}
			
		List<String> expectedlist =	Arrays.asList(coursetitlesvalidate); // comparing the expected arraylist with the actual array list
			Assert.assertTrue(a.equals(expectedlist));// adding the response values in variable a and cmparting it with the coursetitlesvalidate
		
		}

	}



// import librieries like jakson databind, jakson core, jakson annotations, gson which will be used in pojo classes
