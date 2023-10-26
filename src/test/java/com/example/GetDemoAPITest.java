package com.example;

import org.testng.annotations.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class GetDemoAPITest {

	@Test(description = "To get the details of post with correct value")
	public void verifyGetAPI() {

		// Given
		given().baseUri("https://jsonplaceholder.typicode.com")

		// When
		.when().header("Content-Type", "application/json")
		.get("/posts/1")

		// Then
		.then()
		.statusCode(200)

		// To verify correct value
		.body("userId", equalTo(1))
		.body("id", equalTo(1))
		.body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
		.body("body", equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));
	}
}