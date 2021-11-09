package com.unipro.ApiAsure;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class sampleGetRequest {
	public static void main(String[] args) {
		
		
	Response res=	RestAssured.get("http://156.238.16.0");
	int statuscode=res.statusCode();
	String statusline=res.statusLine();	
	System.out.println(statuscode);
	System.out.println(statusline);
	} 

}
