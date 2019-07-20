package websocket.client;

import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.scheduling.concurrent.DefaultManagedTaskScheduler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.lang.reflect.Type;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Client1 {
    private final static String URL = "ws://127.0.0.1:8080/server";
    private final static CountDownLatch LATCH = new CountDownLatch(1);

    public static void main(String[] args) {
        WebSocketClient transport = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(transport);
        stompClient.setMessageConverter(new StringMessageConverter());
        stompClient.setTaskScheduler(new DefaultManagedTaskScheduler());

        Future<StompSession> future = stompClient.connect(URL, new SessionHandler());
        try {
            StompSession session = future.get();
            // 订阅topic
            session.subscribe("/topic/install", new StompFrameHandler() {
                @Override
                public Type getPayloadType(StompHeaders headers) {
                    return String.class;
                }

                @Override
                public void handleFrame(StompHeaders headers, Object payload) {
                    System.out.println(payload);
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        try {
            //阻塞主线程等待websocket线程完成交互
            LATCH.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
