package user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
public class MessageController_ {

    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/trade")
    public String trade(@Payload String pl, Principal principal) {
        System.out.println(pl);

        messagingTemplate.convertAndSendToUser("liujinyao", "/queue/position-updates", "hello liujinyao");

        return "trade";
    }

}
