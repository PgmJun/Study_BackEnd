//package pgmjun.wstest.webSocket;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.simp.config.MessageBrokerRegistry;
//import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
//import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
//import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
//
////STOMP 기반 구현
////WebSocket 연결을 요청할 주소와 SUBSCRIBE, PUBLISH를 요청할 주소를 설정.
//@Configuration
//@EnableWebSocketMessageBroker   //메시지 브로커가 지원하는 ‘WebSocket 메시지 처리’를 활성화한다.
//public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
//
//    // 메모리 기반의 Simple Message Broker를 활성화한다.
//    // 메시지 브로커는 "/subscribe"으로 시작하는 주소의 Subscriber들에게 메시지를 전달하는 역할을 한다.
//    // 이때, 클라이언트가 서버로 메시지 보낼 때 붙여야 하는 prefix를 지정한다.
//    // 예제에서는 "/publish"로 지정하였다.
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        registry.enableSimpleBroker("/subscribe");
//        registry.setApplicationDestinationPrefixes("/publish");
//    }
//
//    //기존의 WebSocket 설정과 마찬가지로 HandShake와 통신을 담당할 EndPoint를 지정한다.
//    //클라이언트에서 서버로 WebSocket 연결을 하고 싶을 때, "/ws-connection"으로 요청을 보내도록 하였다.
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/ws-connection")
//                .setAllowedOrigins("chrome-extension://ggnhohnkfcpcanfekomdkjffnfcjnjam")
//                .withSockJS();
//    }
//
//}
