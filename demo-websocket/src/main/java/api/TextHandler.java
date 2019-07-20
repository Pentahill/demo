package api;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class TextHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println(message.getPayload());

        TextMessage message1 = new TextMessage("hello client".getBytes());
        session.sendMessage(message1);

//        throw new RuntimeException("excepyion");

    }

}
