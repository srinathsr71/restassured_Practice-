package practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class rest_assured_reqres {
	
//public String url="https://reqres.in";	

//get all users
@Test(enabled=false)
public void get_tc1() {
	given().get("https://reqres.in/api/users").then().statusCode(200).log().all();
		
}

//get single user
@Test(enabled=false)
public void get_tc2() {
	given().get("https://reqres.in/api/users/2").then().statusCode(200).log().all();
}

//create user

@Test(enabled=false)
public void post_tc3() {
	JSONObject js=new JSONObject();
	js.put("name", "santhoshkumarset");
	js.put("job", "testing");
	given().contentType(ContentType.JSON).accept(ContentType.JSON)
	.body(js).post("https://reqres.in/api/users").then().statusCode(201).log().all();
}

//Update User

@Test(enabled=false)
public void update_tc4() {
	JSONObject js=new JSONObject();
	js.put("name", "santhoshkumarreddy");
	js.put("job", "Automation");
	given().contentType(ContentType.JSON).accept(ContentType.JSON)
	.body(js).put("https://reqres.in/api/users/686").then().statusCode(200).log().all();
}

//Delete user
@Test(enabled=false)
public void update_tc5() {
	given().delete("https://reqres.in/api/users/686").then().statusCode(204).log().all();
	System.out.println("user deleted successfully");
}


//Register New user

@Test(enabled=false)
public void reg_tc7() {
	JSONObject js=new JSONObject();
	js.put("email", "eve.holt@reqres.in");
	js.put("password", "pistol");
	given().contentType(ContentType.JSON).accept(ContentType.JSON)
	.body(js).post("https://reqres.in/api/register").then().statusCode(200).log().all();	
}

//user login


@Test(enabled=false)
public void login_tc8() {
	JSONObject js=new JSONObject();
	js.put("email", "eve.holt@reqres.in");
	js.put("password", "pistol");
	given().contentType(ContentType.JSON).accept(ContentType.JSON)
	.body(js).post("https://reqres.in/api/login").then().statusCode(200).log().all();
}


}























































