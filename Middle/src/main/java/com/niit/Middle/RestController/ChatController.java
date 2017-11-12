//package com.niit.Middle.RestController;
//
//import java.util.Date;
//
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//
//import com.niit.Backend.Model.Message;
//import com.niit.Backend.Model.OutputMessage;
//
//@Controller
//@RequestMapping("/")
//public class ChatController {
//
//
//    
//  @MessageMapping("/chat")
//  @SendTo("/topic/message")
//  public OutputMessage sendMessage(Message message) {
//    return new OutputMessage(message, new Date());
//  }
//}