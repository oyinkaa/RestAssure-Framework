package testCases;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Post_or_Create_A_Products {
	SoftAssert softAssert = new SoftAssert();
	
	@Test
	public void create_A_Product() {
		
//		{
//		    "name": "Jersey",
//		    "description": "Original",
//		    "price": "100",
//		    "category_id": "7",
//		    "category_name": "Sports"
//		}
//		
//		
//		
		HashMap payload = new HashMap();
		payload.put("name", "Jersey");
		payload.put("description", "Original");
		payload.put("price", "100");
		payload.put("category_id", "7");
		//payload.put("category_name", "Electronics");
		Response response = 
	given()
		.baseUri("https://techfios.com/api-prod/api/product")
		.header("Content-Type", "application/json; charset=UTF-8")
		.body(payload)
	.when()
		.post("/create_one.php")
	.then()
		.extract().response();
		
		
		//System.out.println("Response:" + response);
		
		int statusCode = response.getStatusCode();
		System.out.println("Status Code: " + statusCode);
		softAssert.assertEquals(statusCode, 201);

		String responseHeader = response.header("Contet-Type");
		softAssert.assertEquals(responseHeader, "application/json; charset=UTF-8");
		
		//System.out.println("Response Body:" + response.prettyPrint());
		
		// RESPONSE BODY
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body:" + responseBody);
	
		JsonPath js = new JsonPath(responseBody);
		
		String successmessage = js.getString("message");
		System.out.println("success Message: " + successmessage);
		softAssert.assertEquals(successmessage, "Product was created.", "Message is not matching!");

		String productPrice = js.getString("price");
		System.out.println("Product Price: + productPrice");
		softAssert.assertEquals(productPrice, "100", "Price name is not matching!");
		
		softAssert.assertAll();
		
		
	}  








}
