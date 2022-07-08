package pgmjun.wstest.api;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pgmjun.wstest.dto.MsgRoom;
import pgmjun.wstest.service.MsgService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comm")
public class MsgRoomController {

    private final MsgService msgService;

    @GetMapping("/room")
    public String room(Model model) {
        return "room";
    }

    @GetMapping("/rooms")
    public List<MsgRoom> rooms() {
        List<MsgRoom> allRoom = msgService.findAllRoom();
        for (MsgRoom msgRoom : allRoom) {
            System.out.println("msgRoom.getRoomId() = " + msgRoom.getRoomId());
        }
        return allRoom;

    }

    @ApiOperation(value = "방 입장", notes = "room ID를 통해서 방에 입장합니다.")
    @GetMapping("/room/enter/{roomId}")
    public String roomEnter(
            Model model,
            @ApiParam(value = "방 ID", required = true)
            @PathVariable String roomId) {

        model.addAttribute("roomId", roomId);
        return "comm/roomEnter";
    }

    @ApiOperation(value = "방 조회", notes = "room ID를 통해서 방을 조회합니다.")
    @GetMapping("/room/{roomId}")
    public MsgRoom roomInfo(
            @ApiParam(value = "방 ID", required = true)
            @PathVariable String roomId) {

        return msgService.findById(roomId);
    }

    @PostMapping("/room")
    @ResponseBody
    public MsgRoom createRoom(@RequestParam String name) {
        // TODO : name is Summoner Name
        return msgService.createRoom(name);
    }
}