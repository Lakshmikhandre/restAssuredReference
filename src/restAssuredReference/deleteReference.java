package restAssuredReference;

import static io.restassured.RestAssured.given;
import org.testng.Assert;

import io.restassured.RestAssured;

public class deleteReference {

	public static void main(String[] args) {
		// declare base URI
		RestAssured.baseURI="https://reqres.in/";
		//config request body
		 int statuscode = given().header("content-Type","application/json").log().all().when().delete("/api/users/2").then().extract().statusCode();
         System.out.println(statuscode);
         
	}

}
