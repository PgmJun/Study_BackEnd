package pgmjun.wstest.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pgmjun.wstest.dto.MsgRoom;
import pgmjun.wstest.service.MsgService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
public class MsgController {

    private final MsgService msgService;

    @PostMapping
    public MsgRoom createRoom(@RequestParam String name){
        return msgService.createRoom(name);
    }

    @GetMapping
    public List<MsgRoom> findAllRoom(){
        return msgService.findAllRoom();
    }
}
