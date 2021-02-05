package com.rest.example;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;  
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;  
import javax.ws.rs.core.Application;
import javax.ws.rs.ApplicationPath;
@Path("/value")  
public class HelloParam {
	 @GET  
	  @Produces(MediaType.TEXT_HTML)  
	  public String sayHtmlHello(@QueryParam("name") String name) { 
		 String response;
		 if(name.equals("angel")) {
			 response ="Welcome User";
		 }else {
			 response="Invalid user";
		 }
	    return "<html> " + "<title>" + "Hello World" + "</title>"  
	        + "<body><h1>" +response + "</h1></body>" + "</html> ";  
	  }
}
