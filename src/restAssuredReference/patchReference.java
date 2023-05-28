package restAssuredReference;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import java.time.LocalDate;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class patchReference {

	public static void main(String[] args) {
		
		//step1: declare base URI
				RestAssured.baseURI="https://reqres.in/";
				
				//step2: config requestBody params
				String PatchresponseBody=given().header("content-Type","application/json").body("{\r\n"
						+ "    \"name\": \"morpheus\",\r\n"
						+ "    \"job\": \"zion resident\"\r\n"
						+ "}").when().patch("/api/users/2").then().extract().response().asString();
				
				System.out.println(PatchresponseBody);
				
				//create jsonpath
				JsonPath jsp=new JsonPath(PatchresponseBody);
				
				//extract responsebody params
				String res_name=jsp.getString("name");
				String res_job=jsp.getString("job");
				String res_date=jsp.getString("updatedAt");
				String Date = new String(res_date);
				String result=new String(Date);
				
				System.out.println(res_name);
				System.out.println(res_job);
				System.out.println(res_date);
				System.out.println(Date.substring(0,10));
				System.out.println(result.substring(0,10));
				
				//validate response body
				Assert.assertEquals(res_name,"morpheus");
				Assert.assertEquals(res_job,"zion resident");
				Assert.assertEquals(Date,result);
				
	}

}
