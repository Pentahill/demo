package websocket.client;

import org.springframework.messaging.converter.StringMessageConverter;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.scheduling.concurrent.DefaultManagedTaskScheduler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Client {
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
            SubscribeHandler handler = new SubscribeHandler(session, LATCH);
            // 订阅topic
            session.subscribe("/topic/install/host1", handler);
            // 发送安装请求
            session.subscribe("/api/install/host1", handler);
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
