package pgmjun.wstest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {
    public enum MessageType {
        ENTER, COMM
    }
    private MessageType messageType;
    private String roomId;
    private String sender;
    private String message;
}
