package user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.session.jdbc.config.annotation.web.http.EnableJdbcHttpSession;
import org.springframework.web.socket.config.WebSocketMessageBrokerStats;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
//@EnableJdbcHttpSession
public class Application {

    @Autowired
    WebSocketMessageBrokerStats webSocketMessageBrokerStats;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public MBeanExporter mbeanConfig() {
        MBeanExporter exporter = new MBeanExporter();
        Map<String, Object> beans = new HashMap<>();
        beans.put("socketbean:name=socketbean", webSocketMessageBrokerStats);

        exporter.setBeans(beans);

        return exporter;
    }

}

