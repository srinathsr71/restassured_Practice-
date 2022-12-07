package practice;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class rest_assured_localhost {
	
	//public String url="http://localhost:3000/users";

	
	
//create user	
	
@Test(enabled=false)
public void create_user() {
JSONObject jk=new JSONObject();

jk.put("firstname","santhoshkumar");
jk.put("lastname", "sr");
jk.put("subjectid", "6");

given().contentType(ContentType.JSON).accept(ContentType.JSON)
.body(jk).when().post("http://localhost:3000/users").then().log().all();
	
}

//update user

@Test(enabled=true)
public void update_user() {
JSONObject jk=new JSONObject();

jk.put("firstname","saikumar");
jk.put("lastname", "sy");
jk.put("subjectid", "7");

given().contentType(ContentType.JSON).accept(ContentType.JSON).body(jk).when()
.put("http://localhost:3000/users/6").then().log().all();
	
}

//delete user

@Test(enabled=false)
public void delete_user() {
given().when()
.delete("http://localhost:3000/users/2").then().log().all();
	
}	
//get all users

@Test(enabled=false)
public void getall_user() {

given().when()
.get("http://localhost:3000/users").then().log().all();
	
}

}















