package websocket.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController_ {

    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/trade")
    public void trade(@Payload String hello) {
        System.out.println(hello);
        messagingTemplate.convertAndSend("/topic/install", "trade over");
    }
}
