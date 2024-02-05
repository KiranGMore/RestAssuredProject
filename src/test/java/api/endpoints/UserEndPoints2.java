package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//This is UserEndPoints.java class
//Created for perform Create, Read, Update, Delete request to the user API.

public class UserEndPoints2 
{
	   //Readind data from properties file
	   //This method is creadted for getting URL's from properties file
	   static ResourceBundle getURL()
	   {
		   ResourceBundle routes = ResourceBundle.getBundle("routes");   //Load the properties file
		   return routes;
	   }
	
       public static Response createUser(User payload)
       {
    	    String postURL = getURL().getString("post_url");
    	   
    	    Response response = given()
    	       .contentType(ContentType.JSON)
    	       .accept(ContentType.JSON)
    	       .body(payload)
    	   
    	   .when()
    	       .post(postURL);
    	    
    	    return response;
       }
       
       public static Response readUser(String userName)
       {
    	    String getURL = getURL().getString("get_url");
    	   
    	    Response response = given()
    	       .pathParam("username", userName)
    	       
    	   .when()
    	       .get(getURL);
    	    
    	    return response;
       }
       
       public static Response updateUser(String userName, User payload)
       {
    	    String updateURL = getURL().getString("update_url");
    	   
    	    Response response = given()
    	       .contentType(ContentType.JSON)
    	       .accept(ContentType.JSON)
    	       .body(payload)
    	       .pathParam("username", userName)
    	   
    	   .when()
    	       .put(updateURL);
    	    
    	    return response;
       }
       
       public static Response deleteUser(String userName)
       {
    	    String deleteURL = getURL().getString("delete_url");
    	   
    	    Response response = given()
    	       .pathParam("username", userName)
    	       
    	   .when()
    	       .delete(deleteURL);
    	    
    	    return response;
       }
}






















