package TesteQA;
import static io.restassured.RestAssured.*;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.response.Response;

public class TesteApi {

	@BeforeClass
	public static void urlbase() {
		baseURI = "https://reqres.in";
	}
	
	
	@Test
	public void PostReqresIn() {
		given()
			.contentType("application/json")
			.body("{\"id\": 1378,\"user_id\": 70,\"title\": \"Workshop Test\",\"body\": \"test\"}")
		.when()
			.post("/api/users")
		.then()
			.log().all()
			.statusCode(201);
	}
	
	@Test
	public void GetSingleUserReqresIn() {
		given()
		.when()
			.get("/api/users/2")
		.then()
			.log().all()
			.statusCode(200);
	}
	
	@Test
	public void GetListUsersReqresIn() {
		given()
		.when()
			.get("/api/users?page=2")
		.then()
			.log().all()
			.statusCode(200);
	}
	
	@Test
	public void PatchReqresIn() {
		given()
			.contentType("application/json")
			.body("{\"name\": \"edna\",\"job\": \"zion resident\"}")
		.when()
			.patch("/api/users/2")
		.then()
			.log().all()
			.statusCode(200);
	}
	
}
