package pgmjun.wstest.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Slf4j
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws/swoomi")
                .setAllowedOrigins("*") // setAllowedOrigins("*")에서 *라는 와일드 카드를 사용하면 보안 이슈가 발생할 수 있으므로 전체를 허용하는 것보다 직접 하나씩 지정해주어야 한다고 한다.
                .withSockJS(); // WebSocket을 지원하지 않는 브라우저를 위해 SockJS를 추가해주기 위해 .withSockJS() 추가
    }
    // :: sub/pub 메시징 구현 ::
    // 메시지를 발행하는 요청의 prefix는 [/pub]으로 시작하도록 설정
    // 메시지를 구독하는 요청의 prefix는 [/sub]으로 시작하도록 설정
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry){
        registry.enableSimpleBroker("/sub");
        registry.setApplicationDestinationPrefixes("/pub");
    }


}