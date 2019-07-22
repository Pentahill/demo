//package user;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.Message;
//import org.springframework.messaging.MessageChannel;
//import org.springframework.messaging.MessageHandler;
//import org.springframework.messaging.converter.MessageConverter;
//import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
//import org.springframework.messaging.simp.config.ChannelRegistration;
//import org.springframework.messaging.simp.config.MessageBrokerRegistry;
//import org.springframework.messaging.support.ChannelInterceptor;
//import org.springframework.messaging.support.ExecutorChannelInterceptor;
//import org.springframework.scheduling.TaskScheduler;
//import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
//import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
//import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
//
//import java.util.List;
//
//@Configuration
//@EnableWebSocketMessageBroker
//public class StompConfig implements WebSocketMessageBrokerConfigurer {
//
//    private TaskScheduler messageBrokerTaskScheduler;
//
//    @Autowired
//    public void setMessageBrokerTaskScheduler(TaskScheduler taskScheduler) {
//        this.messageBrokerTaskScheduler = taskScheduler;
//    }
//
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint( "/server").setAllowedOrigins("*");
//    }
//
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        registry.setApplicationDestinationPrefixes("/api")
//                .enableSimpleBroker("/topic")
////                .setHeartbeatValue(new long[] {1000, 2000})
////                .setTaskScheduler(messageBrokerTaskScheduler)
//        ;
//
//        registry.configureBrokerChannel().interceptors(new BrokerInterceptor());
//    }
//
//    @Override
//    public void configureClientInboundChannel(ChannelRegistration registration) {
//        registration.interceptors(new LogInterceptor());
//    }
//
//    @Override
//    public void configureClientOutboundChannel(ChannelRegistration registration) {
////        registration.interceptors(new LogInterceptor());
//    }
//
//
//    @Override
//    public boolean configureMessageConverters(List<MessageConverter> messageConverters) {
//        return true;
//    }
//
//    class BrokerInterceptor implements ExecutorChannelInterceptor {
//        @Override
//        public Message<?> beforeHandle(Message<?> message, MessageChannel channel, MessageHandler handler) {
//            System.out.println("beforeHandle");
//            return message;
//        }
//
//        @Override
//        public void afterMessageHandled(Message<?> message, MessageChannel channel, MessageHandler handler, Exception ex) {
//            System.out.println("afterMessageHandled");
//        }
//    }
//
//    class LogInterceptor implements ChannelInterceptor {
//        @Override
//        public Message<?> preSend(Message<?> message, MessageChannel channel) {
//            SimpMessageHeaderAccessor accessor = SimpMessageHeaderAccessor.wrap(message);
//            System.out.println(accessor.getDetailedLogMessage(message.getPayload()));
//
//            return message;
//        }
//    }
//
//}
