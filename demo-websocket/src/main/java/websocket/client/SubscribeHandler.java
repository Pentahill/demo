package websocket.client;

import org.springframework.messaging.simp.stomp.StompFrameHandler;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;

import java.lang.reflect.Type;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SubscribeHandler implements StompFrameHandler {
    private CountDownLatch countDownLatch;
    private StompSession session;

    private ExecutorService service = Executors.newCachedThreadPool();

    public SubscribeHandler(StompSession session, CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
        this.session = session;
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return String.class;
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {

        // 消息头部包含type字段，且等于 "command"
        if(headers.containsKey("type") && "command".equals(headers.get("type"))) {
            System.out.println("[Agent] server message: " + payload);
        }

        // 消息体为 ”ok“
        if ("ok".equalsIgnoreCase((String) payload)) {
           service.execute(new InstallTask());
        } else {
            System.out.println("[Agent] server message: " + payload);
        }

    }

    class InstallTask implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("[Agent] starting install service");
                //安装开始，向服务端发送心跳
                session.send("/api/install/host1", "start");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // 安装组件
                int i = 10;
                while (i <= 100) {
                    try {
                        String progress = i + "%";
                        session.send("/api/install/host1", progress);
                        System.out.println(progress);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i = i + 10;
                }
                System.out.println(" Done");

                //安装完成，向服务端发送心跳
                session.send("/api/install/host1", "complete");
            } finally {
                service.shutdown();
                // 安装结束，释放主线程
                countDownLatch.countDown();
            }
        }
    }
}
