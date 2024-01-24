import Files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
// 6th folder ***** 3rd lesson*******
		
		JsonPath js = new JsonPath(Payload.coursePrice());
		// 1.Print No of courses returned by API
		int courseCount = js.get("courses.size()");
		System.out.println(courseCount);
		// 2.Print Purchase Amount
		int purchaseAmount = js.get("dashboard.purchaseAmount");
		System.out.println(purchaseAmount);
		// 3. Print Title of the first course
//		String courseName = js.get("courses[0].title");
//		System.out.println(courseName);
		
// 6th folder *********4th lesson*******	
// 4. Print All course titles and their respective Prices
		for(int coursesList=0; coursesList<courseCount; coursesList++)
		{
		System.out.println(js.get("courses["+coursesList+"].title").toString());
		System.out.println(js.get("courses["+coursesList+"].price").toString());
		}
		
		System.out.println("print no of courses sold by RPS course");
	
// 6th folder ******* 5th lesson********
		
		for(int coursesList=0; coursesList<courseCount; coursesList++)
		{
			String courseTitles = js.get("courses["+coursesList+"].title");
			if(courseTitles.equalsIgnoreCase("RPA"))
			{
			int copies	= js.get("courses["+coursesList+"].copies");
			System.out.println(copies);
			break;
			}
			
// 6th folder *******6th lesson********
			
//	moved to separate class sum validation 
			
		}
		
	}

}
