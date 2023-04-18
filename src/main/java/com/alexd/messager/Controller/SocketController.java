package com.alexd.messager.Controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SocketController {
    //send messages.
    @MessageMapping("/message")
    @SendTo("/topic/newMessage")
    public String sendMessage(String message) {
        return message;
    }
}
