package com.model.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.model.example.Message;
import com.model.service.MessageService;
@Path("/messages")
public class MessageResource {
	MessageService messageService=new MessageService();
	 @GET  
	  @Produces(MediaType.APPLICATION_JSON)  
	  public List<Message>getAllMessages() {  
	    return messageService.getAllMessages();  
	  }  
	 @POST
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 public Message addMessage(Message message) {
		 return messageService.addMessage(message);
	 }
	 @PUT
	 @Path("/{messageId}")
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 public Message updateMessage(@PathParam("messageId") long id,Message message) {
		 message.setId(id);
		 return messageService.updateMessage(message);
	 }
	 @DELETE
	 @Path("/{messageId}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public void deleteMessage(@PathParam("messageId") long id) {
		 messageService.removeMessage(id);
	 }
	 
	 @GET  
	 @Path("/{messageId}")
	  @Produces(MediaType.APPLICATION_JSON)  
	 public Message getMessage(@PathParam("messageId") long messageId) {
		 return messageService.getMessage(messageId);
	 }
}
