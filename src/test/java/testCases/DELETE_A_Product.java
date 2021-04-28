package testCases;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;

public class DELETE_A_Product {
	SoftAssert  softAsssert = new SoftAssert();

	@Test
	public void update_A_Products() {
		HashMap payload = new HashMap();
		payload.put("id", "1484");
        payload.put("name", "iPhone");
        payload.put("price", "1000");
		
				
//				{
//		    "id": "1484",
//		    "name": "Samsung Phone",
//		    "description": "Good Phone",
//		    "price": "453",
//		    "category_id": "5",
//		    "category_name": "Electronics"
//		}		
//				
//				
				
		Response response = 
		
	given()
		.baseUri("https://techfios.com/api-prod/api/product")
		.header("Content-Type", "application/json; charset=UTF-8")
	.when()
		.put("/update.php")
	.then()
		.extract().response();
		
		
		//System.out.println("Response:" + response);
		
		int statusCode = response.getStatusCode();
		System.out.println("Status Code:" + statusCode);
		softAsssert.assertEquals(statusCode, 200, "Status code is not matching!");
		
		softAsssert.assertAll();
		
		
		
		
		
	}








}
