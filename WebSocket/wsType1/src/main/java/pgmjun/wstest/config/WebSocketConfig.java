package pgmjun.wstest.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import pgmjun.wstest.ws.ChatHandler;

@Slf4j
@Configuration
@RequiredArgsConstructor
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final ChatHandler chatHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {

        registry.addHandler(chatHandler, "/ws/chat")
                .setAllowedOrigins("*");

        // WebSocket을 지원하지 않는 브라우저를 위해 SockJS를 추가해주기 위해 .withSockJS() 추가
        // setAllowedOrigins("*")에서 *라는 와일드 카드를 사용하면 보안 이슈가 발생할 수 있으므로
        // 전체를 허용하는 것보다 직접 하나씩 지정해주어야 한다고 한다.
    }
}