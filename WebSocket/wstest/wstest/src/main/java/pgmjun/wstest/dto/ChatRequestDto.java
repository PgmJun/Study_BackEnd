package pgmjun.wstest.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NoArgsConstructor
public class ChatRequestDto {

    //송신자 ID
    @NonNull
    private Long senderId;

    //수신자 ID
    @NonNull
    private Long receiverId;


    //채팅방 ID
    @NonNull
    private Long roomId;

    //메시지 내용
    @NonNull
    private String message;

    public ChatRequestDto(Long senderId, Long receiverId, Long roomId, String message) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.roomId = roomId;
        this.message = message;
    }
}
