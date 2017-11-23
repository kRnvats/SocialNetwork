package com.niit.Middle.RestController;


import java.util.Date;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;



import com.niit.Backend.Model.Message;
import com.niit.Backend.Model.OutputMessage;

@Controller

public class ChatController {
	  
	  @MessageMapping("/chat")   ///sendMessage
	  @SendTo("/topic/message")        //receiveMessage
	  public OutputMessage sendMessage(Message message) {
		  
	    return new OutputMessage(message,new Date()); 
	    
	  
	  
	  }


}