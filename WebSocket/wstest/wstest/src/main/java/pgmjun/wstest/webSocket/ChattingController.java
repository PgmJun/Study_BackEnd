//package pgmjun.wstest.webSocket;
//
//import lombok.AllArgsConstructor;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//import pgmjun.wstest.dto.ChatRequestDto;
//
//@RestController
//@AllArgsConstructor
//public class ChattingController {
//    private final SimpMessagingTemplate simpMessagingTemplate;
//
//    // Client가 SEND를 할 수 있는 경로이다.
//    // WebSocketConfig에서 등록한 applicationDestinationPrfixes와 @MessageMapping의 경로가 합쳐진다.(/publish/messages)
//    @MessageMapping("/messages")
//    public void chat(@RequestBody ChatRequestDto chatRequestDto){
//        System.out.println("Message = " + chatRequestDto.getMessage() + "\n" +
//                "roomId = " + chatRequestDto.getRoomId());
//        simpMessagingTemplate.convertAndSend("/subscribe/rooms/"+chatRequestDto.getRoomId(),chatRequestDto.getMessage());
//    }
//}
