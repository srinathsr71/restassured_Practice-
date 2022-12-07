
	package practice;

	import  io.restassured.RestAssured;
	import io.restassured.http.ContentType;
	import io.restassured.response.Response;
	import static io.restassured.RestAssured.*;
	import static org.hamcrest.CoreMatchers.hasItems;
	import static org.hamcrest.CoreMatchers.is;

	import java.util.List;

	import org.json.simple.JSONObject;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	public class rest_assured_practice2 {
		
		public String url="https://jsonplaceholder.typicode.com/posts";
		public String ur11="https://gorest.co.in/public/v2/users";
		
		
		@Test(enabled=false)
		public void test1() {
			Response res=RestAssured.get(ur11);
			int actual=res.getStatusCode();
			Assert.assertEquals(actual, 200);
		}
		
		
		@Test(enabled=false)
		public void test2() {
			
			//public List<test> list;
			given().get(url).then().body("data.firstname", hasItems("santhosh"));
			//given().get(url).then().assertThat().body("size()", is(2));
			//given().get("posts").then().log().all();
		
			
		}
		
		@Test(enabled=false)
		public void test3() {
			given().get("https://reqres.in/api/users").then().body("data.firstname", hasItems("qui est esse"));
			given().get("users").then().log().all();
		}
		
		@Test(enabled=false)
		public void test4() {
			JSONObject JS=new JSONObject();
			JS.put("name", "srinath");
			JS.put("job", "tester");
			given().body(JS.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();//creating user
			given().body(JS.toJSONString()).when().put("https://reqres.in/api/users/2").then().statusCode(200).log().all();//updating user
			given().delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();//delete user.
					
		}
		
		@Test(enabled=false)
		public void test5() {
			
			given().get("https://reqres.in/api/users/2").then().statusCode(200).log().all();//getting single user
						
		}	
		@Test(enabled=true)
		public void test6() {
			JSONObject js=new JSONObject();
			js.put("email", "eve.holt@reqres.in");
			js.put("password","pistol");
			//Response indu=given().body(js).when().post("https://reqres.in/api/users/2").then().statusCode(201).and().log().all();
			given().contentType(ContentType.JSON).accept(ContentType.JSON).body(js).post("https://reqres.in/api/register").then().statusCode(201).log().all();
			//resp.prettyPrint();
		}
		
		@Test(enabled=true)
		public void test7() {
			JSONObject JS=new JSONObject();
			JS.put("email", "eve.holt@reqres.in");
			JS.put("password","pistol");
			//Response res=given().queryParam("token", "QpwL5tke4Pnpja7X4").contentType(ContentType.JSON).log().all().body(js).post("https://reqres.in/api/register");
			//res.prettyPrint();
			given().contentType(ContentType.JSON).accept(ContentType.JSON).body(JS.toJSONString()).when().post("https://reqres.in/api/login").then().statusCode(200).log().all();				
		}
		
		
		@Test(enabled=false)
		public void test8() {
			JSONObject js=new JSONObject();
			js.put("name", "sathvik");
			js.put("job","team leader");
			//Response indu=given().body(js).when().post("https://reqres.in/api/users/2").then().statusCode(201).and().log().all();
			Response resp=given().contentType(ContentType.JSON).log().all().body(js).post("https://reqres.in/api/users/2");
			resp.prettyPrint();
			
		}		

	}


