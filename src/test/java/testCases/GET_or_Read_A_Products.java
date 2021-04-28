package testCases;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GET_or_Read_A_Products {
SoftAssert softAssert = new SoftAssert();

	@Test
	public void read_A_Products() {
		Response response = 
		
	given()
		.baseUri("http://techfios.com/api-prod/api/product")
		.header("Content-Type", "application/json; charset=UTF-8")
		.queryParam("id", "1473")
	.when()
		.get("/read_one.php")
	.then()
		.extract().response();
		
		
		//System.out.println("Response:" + response);
		
		int statusCode = response.getStatusCode();
		System.out.println("Status Code:" + statusCode);
		Assert.assertEquals(statusCode, 200);
		
		// RESPONSE TIME
		long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
		System.out.println("Response Time:" + responseTime);
		if(responseTime<=2000) {
			System.out.println("Response time is within range!");
		}else {
			System.out.println("Response time is out of range!");
		}
		
		//System.out.println("Response Body:" + response.prettyPrint());
		
		// RESPONSE BODY
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body:" + responseBody);
		
		JsonPath js = new JsonPath(responseBody);
		String productId = js.getString("id");
		System.out.println("Product Id:" + productId);
		//softAssert.assertEquals(productId, 1473 , "Assert not found!");
		
		String productName = js.getString("name");
		System.out.println("Product Name:");
		softAssert.assertEquals(productName, "Amazing Pillow For QA's 3.0");
		
		String productDescription = js.getString("desription");
		System.out.println("Product Description");
		
		softAssert.assertAll();
		
		
		
	}








}
