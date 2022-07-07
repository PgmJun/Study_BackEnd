package pgmjun.wstest.ws;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import pgmjun.wstest.dto.Message;
import pgmjun.wstest.dto.MsgRoom;
import pgmjun.wstest.service.MsgService;

import java.io.EOFException;

@Component
@Log4j2
@RequiredArgsConstructor
public class ChatHandler extends TextWebSocketHandler {

    private final MsgService msgService;
    private final ObjectMapper objectMapper;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("payload : {}", payload);

        Message msg = objectMapper.readValue(payload, Message.class);
        MsgRoom room = msgService.findById(msg.getRoomId());
        room.handleActions(session, msg, msgService);
    }

}
