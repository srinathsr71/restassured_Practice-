package practice;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class rest_assured_trello {

	public String url="https://api.trello.com/";
	//public String ur11="https://gorest.co.in/public/v2/users";
	
	
//	@Test
//	public void test1() {
//		Response res=RestAssured.get(url);	
//	}
	
	
//Create a Board	
@Test(enabled=false)
public void create() {
	//JSONObject js=new JSONObject();
	//js.put("name", "Testing");
	baseURI=url;
	given().queryParam("name","Testing").queryParam("key","0ca1731bdb933b53695b7ccaea733e71")
	.queryParam("token","f5afb2fadce5da79d715b1eb1ce546ee5d7f637d3d75cb7d17f84d74c6f5e08f")
	.when()
	.contentType(ContentType.JSON).accept(ContentType.JSON)
	.post("/1/boards/").then().log().all();
	
}


//update a board

@Test(enabled=false)
public void update() {
	//JSONObject js=new JSONObject();
	//js.put("name", "Testing");
	baseURI=url;
	given().queryParam("name","AutomationTesting").queryParam("key","0ca1731bdb933b53695b7ccaea733e71")
	.queryParam("token","f5afb2fadce5da79d715b1eb1ce546ee5d7f637d3d75cb7d17f84d74c6f5e08f")
	.when()
	.contentType(ContentType.JSON).accept(ContentType.JSON)
	.put("/1/boards/zoU088lN").then().log().all();
	
}

//Delete a board

@Test(enabled=false)
public void delete() {
	//JSONObject js=new JSONObject();
	//js.put("name", "Testing");
	baseURI=url;
	given().queryParam("key","0ca1731bdb933b53695b7ccaea733e71")
	.queryParam("token","f5afb2fadce5da79d715b1eb1ce546ee5d7f637d3d75cb7d17f84d74c6f5e08f")
	.when()
	.contentType(ContentType.JSON).accept(ContentType.JSON)
	.delete("/1/boards/zoU088lN").then().log().all();
	
}

//Get a Board

@Test(enabled=false)
public void get_tc1() {
	//JSONObject js=new JSONObject();
	//js.put("name", "Testing");
	baseURI=url;
	given().queryParam("key","0ca1731bdb933b53695b7ccaea733e71")
	.queryParam("token","f5afb2fadce5da79d715b1eb1ce546ee5d7f637d3d75cb7d17f84d74c6f5e08f")
	.when()
	.contentType(ContentType.JSON).accept(ContentType.JSON)
	.get("/1/boards/zoU088lN").then().log().all();
	
}


//Get all boards

@Test(enabled=true)
public void get_all() {
	//JSONObject js=new JSONObject();
	//js.put("name", "Testing");
	baseURI=url;
	given().queryParam("key","0ca1731bdb933b53695b7ccaea733e71")
	.queryParam("token","f5afb2fadce5da79d715b1eb1ce546ee5d7f637d3d75cb7d17f84d74c6f5e08f")
	.when()
	.contentType(ContentType.JSON).accept(ContentType.JSON)
	.get("1/members/me/boards").then().log().all();
	
}
}


























