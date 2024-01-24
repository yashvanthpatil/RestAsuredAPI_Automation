import org.testng.Assert;
import org.testng.annotations.Test;

import Files.Payload;
import io.restassured.path.json.JsonPath;


public class SumValidation {
	
	@Test
	public void sumofCourses()
	{
		int amount = 0;
		int addAmount = 0;
		JsonPath js = new JsonPath(Payload.coursePrice());
		int count = js.get("courses.size()");
		for(int totalPrice=0; totalPrice<count; totalPrice++)
		{
			int price = js.get("courses["+totalPrice+"].price");
			int copies = js.get("courses["+totalPrice+"].copies");
			amount = price * copies;
			System.out.println(amount);
			
			addAmount =addAmount+ amount;
			
		}
		
		System.out.println("Total amount is = "+addAmount);
		int purchaseAmount = js.get("dashboard.purchaseAmount");
		Assert.assertEquals(purchaseAmount, addAmount);
	}
		// 6th folder *************6th lesson completed*************
	
	
	//*********** 7th floder 1st leson intrudction about payload for dynamic API and usage of new library API***************************
}
