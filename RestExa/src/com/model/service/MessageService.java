package com.model.service;
import com.model.database.DatabaseClass;
import com.model.example.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MessageService {
	
	private  Map<Long,Message>messages=DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1L,new Message(1,"Hello World","Jersey"));
		messages.put(2L,new Message(2,"Hello Java","Jackson"));
	}
public List<Message>getAllMessages() {
	return new ArrayList<Message>(messages.values());
}
public Message getMessage(long id) {
	return messages.get(id);
}
public Message addMessage(Message message) {
	message.setId(messages.size()+1);
	messages.put(message.getId(), message);
	return message;
}
public Message updateMessage(Message message) {
	if(message.getId()<=0) {
		return null;
	}
	messages.put(message.getId(),message);
	return message;
}
public Message removeMessage(long id) {
	return messages.remove(id);
}
//	Message m1=new Message(1,"HEY","Archana");
//	Message m2=new Message(2,"HEY Java","June");
//	Message m3=new Message(3,"HEY Jersey","Summer");
//	List<Message>list=new ArrayList<>();
//	list.add(m1);
//	list.add(m2);
//	list.add(m3);
//	return list;
//}
}
