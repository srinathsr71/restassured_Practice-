package practice;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class rest_assured_trello2 {

	public String url="https://api.trello.com";
	public String key="0ca1731bdb933b53695b7ccaea733e71";
	public String token="f5afb2fadce5da79d715b1eb1ce546ee5d7f637d3d75cb7d17f84d74c6f5e08f";
	public String id;
	
//Create a Board	
@Test(enabled=true)
public void create() {
	//JSONObject jr=new JSONObject();
	baseURI=url;
	Response res=given().queryParam("name","Demorest1")
			.queryParam("key",key)
	.queryParam("token",token)
	.when()
	.contentType(ContentType.JSON).accept(ContentType.JSON)
	.post("/1/boards/").then().extract().response();
	String s=res.asString();
	JsonPath jt=new JsonPath(s);
	id=jt.get("id");
	System.out.println(id);	
	
}


//update a board

@Test(enabled=true)
public void update() {

	baseURI=url;
	given().queryParam("name","ManualTesting").queryParam("key",key)
	.queryParam("token",token)
	.when()
	.contentType(ContentType.JSON).accept(ContentType.JSON)
	.put("/1/boards/"+id).then().log().all();
	
}

//Delete a board

@Test(enabled=true)
public void delete() {
	//JSONObject js=new JSONObject();
	//js.put("name", "Testing");
	baseURI=url;
	given().queryParam("key",key)
	.queryParam("token",token)
	.when()
	.contentType(ContentType.JSON).accept(ContentType.JSON)
	.delete("/1/boards/"+id).then().log().all();
	
}

//Get a Board

@Test(enabled=true)
public void get_tc1() {
	//JSONObject js=new JSONObject();
	//js.put("name", "Testing");
	baseURI=url;
	given().queryParam("key",key)
	.queryParam("token",token)
	.when()
	.contentType(ContentType.JSON).accept(ContentType.JSON)
	.get("/1/boards/"+id).then().log().all();
	
}


//Get all boards

@Test(enabled=true)
public void get_all() {
	//JSONObject js=new JSONObject();
	//js.put("name", "Testing");
	baseURI=url;
	given().queryParam("key",key)
	.queryParam("token",token)
	.when()
	.contentType(ContentType.JSON).accept(ContentType.JSON)
	.get("1/members/me/boards").then().log().all();
	
}	
}
