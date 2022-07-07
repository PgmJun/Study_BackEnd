package pgmjun.wstest.webSocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class PureWebSocketConfig implements WebSocketConfigurer {
    //WebSocketHandlerRegistry에 WebSocketHandler의 구현체를 등록했다.
    // 등록된 Handler는 "/myHandler" 엔드 포인트로 Handshake를 완료한 후 맺어진 연결을 관리한다.

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(myHandler(), "/myHandler");
    }

    @Bean
    public WebSocketHandler myHandler() {
        return new MyHandler();
    }
}