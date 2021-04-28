package testCases;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PUT_or_Update_A_Product {
	SoftAssert  softAssert = new SoftAssert();

	@Test
	public void update_A_Products() {
		HashMap payload = new HashMap();
		payload.put("name", "iPhone");
		payload.put("description", "Smart Phone");
        payload.put("price", "1300");
		
				
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
		.baseUri("https://techfios.com/api-prod/api/product/create.php")
		.header("Content-Type", "application/json; charset=UTF-8")
		.queryParam("id", "1503")
	.when()
		.put("/create.php")
	.then()
		.extract().response();
		
		
		//System.out.println("Response:" + response);
		
		int statusCode = response.getStatusCode();
		System.out.println("Status Code:" + statusCode);
		softAssert.assertEquals(statusCode, 200);
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body:" + responseBody);
		
		JsonPath js = new JsonPath(responseBody);
		String productId = js.getString("id");
		System.out.println("Product Id:" + productId);
		softAssert.assertEquals(productId, 1503, "Product id is not matching!");
		
		String productName = js.getString("name");
		System.out.println("Product Name: + productName");
		softAssert.assertEquals(productName, "iPhone", "Product name is not matching!");

		String productPrice = js.getString("price");
		System.out.println("Product Price: + productPrice");
		softAssert.assertEquals(productPrice, "1300", "Price name is not matching!");
		
		softAssert.assertAll();
		
		
		
		
	}








}
