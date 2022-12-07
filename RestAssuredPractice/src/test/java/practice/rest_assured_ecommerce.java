package practice;


	import org.json.simple.JSONObject;
	import org.testng.annotations.Test;
	import io.restassured.RestAssured;
	import io.restassured.http.ContentType;
	import io.restassured.path.json.JsonPath;
	import io.restassured.response.Response;
	//import io.restassured.RestAssured.*;
	import static io.restassured.RestAssured.*;
	public class rest_assured_ecommerce {
		
		public  String url="https://ecommerceservice.herokuapp.com";
		//public String Accesstoken="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczOGVhYzllYjcxMzAwMTc2MmE1ZDEiLCJpYXQiOjE2Njg1MjA5NTUsImV4cCI6MTY2ODYwNzM1NX0.cliYXNV6kTGHRnuoFusrOOka7hVvXVzWhgeaCyPJs10";
		 public String token;
		@Test(enabled=false)
		public void user_register()
		{
			RestAssured.baseURI=url;
					
			JSONObject js=new JSONObject();
			
		js.put("email", "madhu12344@gmail.com");
		js.put("password", "ml1224");
			
		given().contentType(ContentType.JSON).accept(ContentType.JSON).when().body(js.toJSONString()).post("/user/signup").then()
		.statusCode(201).log().all();
			
			
		}
		@Test(enabled=true)
		public void user_login()
		{
			
			
			RestAssured.baseURI=url;
			JSONObject js=new JSONObject();
			js.put("email", "madhu12344@gmail.com");
			js.put("password", "ml1224");
			
		Response R=	given().contentType(ContentType.JSON).accept(ContentType.JSON).body(js.toJSONString()).when().post("/user/login")
			.then().extract().response();
		String jsonresponse=R.asString();
		JsonPath jp=new JsonPath(jsonresponse);
		//System.out.println(jsonresponse);
			 token=jp.get("accessToken");
			System.out.println(token);
			
			
			
		}
		@Test(enabled=true)
		public void getalluser()
		{				
			//System.out.println(Accesstoken);
			RestAssured.baseURI=url;
			JSONObject js=new JSONObject();
			//given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2MzczOGVhYzllYjcxMzAwMTc2MmE1ZDEiLCJpYXQiOjE2Njg1MjA5NTUsImV4cCI6MTY2ODYwNzM1NX0.cliYXNV6kTGHRnuoFusrOOka7hVvXVzWhgeaCyPJs10")
//			.contentType(ContentType.JSON)
//			.when().get("/user").then().log().all();
			//given().auth().oauth2(token).contentType(ContentType.JSON).accept(ContentType.JSON).when().get("/user").then().log().all();		
		//System.out.println(res);
			given().auth().oauth2(token).when().get("/user").then().log().all();
		}
		
		
		
		
		
		
	}


