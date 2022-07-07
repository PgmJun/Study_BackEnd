package pgmjun.wstest.webSocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyHandler extends TextWebSocketHandler {
    //handleTextMessage 메서드는 웹 소켓 연결이 수립된 후, 해당 연결을 이용하는 세션과 메시지에 대해 다룬다.
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println(message);
        System.out.println(message.getPayload());
    }

    //afterConnectionEstablished 메서드는 연결이 수립된 직후의 행위를 지정한다.
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("afterConnectionEstablished:" + session.toString());
    }

    //afterConnectionClosed 메서드는 연결이 닫힌 직후의 행위를 지정한다.
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
    }

}
