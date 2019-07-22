package websocket.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
public class MessageController_ {

    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @Autowired
    HttpServletRequest request;

//    @SubscribeMapping("/trade")
    @MessageMapping("/trade")
    public String trade(Message message, MessageHeaders headers,
                        MessageHeaderAccessor messageHeaderAccessor,
                        SimpMessageHeaderAccessor simpMessageHeaderAccessor,
                        StompHeaderAccessor stompHeaderAccessor
//                      Principal principal,
//                      @Payload String hello
    ) {
        System.out.println("trade");
        messagingTemplate.convertAndSend("/topic/install", "trade over");

        if(true) throw new RuntimeException("trade");

        return "trade";
    }

    @MessageExceptionHandler
    public Exception messageException(Exception ex) {
        ex.printStackTrace();

        return ex;
    }

}
