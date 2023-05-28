package restAssuredReference;

import static io.restassured.RestAssured.given;

import java.time.LocalDateTime;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class postpractice {

	public static void main(String[] args) {
		//declare base uri and request body variables
		   String BaseURI = "https://reqres.in/";
		   String RequestBody = "{\r\n"
						+ "    \"name\": \"morpheus\",\r\n"
						+ "    \"job\": \"leader\"\r\n"
						+ "}";
		   RestAssured.baseURI= "https://reqres.in/";
	   //Fetch requestbody param values
		    JsonPath jsprequest = new JsonPath(RequestBody);
			String req_name=jsprequest.getString("name");
			String req_job=jsprequest.getString("job");
			
	  //config requestbody
		int statuscode = given().header("content-Type","application/json").body(RequestBody).when().post("/api/users").then().extract().statusCode();
		String ResponseBody = given().header("content-Type","application/json").body(RequestBody).when().post("/api/users").then().log().all().extract().response().asString();
		System.out.println(ResponseBody);

		//parse the response body
			JsonPath jp = new JsonPath(ResponseBody);
			String res_name = jp.getString("name");
			String res_job = jp.getString("job");
			String res_id = jp.getString("id");
			String res_createdAt = jp.getString("createdAt");
						
			//extract data from createdAt parameter
			 LocalDateTime date=LocalDateTime.now();
			 String exp_date=date.toString().substring(0,10);
			 
			//step 4 validate the response body parameter
				Assert.assertEquals(res_name,req_name);
				Assert.assertEquals(res_job,req_job);
				Assert.assertNotNull(res_id);
				
			    
			    
			

	}

}
