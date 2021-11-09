package com.unipro.ApiAsure;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;




public class SampleAPIresponse {
	
	@Test
	public void getreq() {
		  
	Response res=RestAssured.get("https://reqres.in/api/users/2");
	
	//res.getBody();
	   ResponseBody responsebody=res.body();
	    
	    System.out.println(responsebody);
	  
	
	}
	
	
	
	

}
