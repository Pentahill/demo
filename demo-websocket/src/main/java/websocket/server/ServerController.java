package websocket.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ServerController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // 接收客户端的心跳（安装进度）
    @MessageMapping("/install/{host}")
    public void install(@DestinationVariable("host")String host, @Payload String p) {
        if("start".equals(p)) {
            System.out.println("[Server] Agent " + host + " start install");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 回传客户端消息，头部设置type字段
            Map<String, Object> headers = new HashMap<>();
            headers.put("type", "command");
            messagingTemplate.convertAndSend("/topic/install/"+host, "yes", headers);
        } else {
            System.out.println(p);
        }
    }

    // 接收客户端安装请求，并允许其安装
    @SubscribeMapping("/install/{host}")
    public String subscribe(@DestinationVariable("host") String host) {
        System.out.println("[Server] Agent " + host + " is ready" );

        return "ok";
    }
}
