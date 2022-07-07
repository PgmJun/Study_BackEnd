package pgmjun.wstest.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.WebSocketSession;
import pgmjun.wstest.service.MsgService;

import java.util.HashSet;
import java.util.Set;

@Data
public class MsgRoom {
    // 채팅방 ID
    private String roomId;
    // 채팅방은 현재 방에 입장한 클라이언트의 Session 정보를 가져야 한다.
    private Set<WebSocketSession> sessions = new HashSet<>();

    @Builder
    public MsgRoom(String roomId){
        this.roomId = roomId;
    }


    // 채팅방에는 입장 / 통신 기능이 있으므로 handleAction을 통해 분기 처리한다.
    // 입장시에는 채팅방의 session 정보 리스트에 클라이언트의 session을 추가해놓고,
    // 채팅방에 메시지가 도착할 경우 채팅방의 모든 session에 메시지를 발송하면 된다.

    public void handleActions(WebSocketSession session, Message message, MsgService msgService){
        if (message.getMessageType().equals(Message.MessageType.ENTER)) {
            sessions.add(session);
            message.setMessage(message.getSender() + "님이 입장했습니다.");
        }
        sendMessage(message,msgService);
    }
    //parallelStream(): 스트림 병렬처리(기능good)
    public <T> void sendMessage(T message, MsgService messageService){
        sessions.parallelStream().forEach(session -> messageService.sendMessage(session,message));
    }
}
