package com.socket_pro.controller;

import com.socket_pro.model.MessageModel;
import com.socket_pro.storage.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @MessageMapping("/chat/{to}")
    public void sendMessage(@DestinationVariable String to , MessageModel message)
    {
        System.out.println("Handling send message" + message +"to : " + to);
        boolean isExists = UserStorage.getInstaance().getUsers().contains(to);
        if(isExists)
        {
            simpMessagingTemplate.convertAndSend("/topic/messages/" + to , message );

        }
    }
}
