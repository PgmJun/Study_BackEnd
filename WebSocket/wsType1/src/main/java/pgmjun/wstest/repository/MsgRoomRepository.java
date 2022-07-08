package pgmjun.wstest.repository;

import org.springframework.stereotype.Repository;
import pgmjun.wstest.dto.MsgRoom;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class MsgRoomRepository {

    private Map<String, MsgRoom> msgRoomMap;

    @PostConstruct
    private void init() {
        msgRoomMap = new LinkedHashMap<>();
    }

    public List<MsgRoom> findAllRoom() {
        List<MsgRoom> msgRooms = new ArrayList(msgRoomMap.values());
        Collections.reverse(msgRooms);
        return msgRooms;
    }

    public MsgRoom findByRoomId(String roomId) {
        return msgRoomMap.get(roomId);
    }

    public MsgRoom createMsgRoom(String name) {
        MsgRoom room = MsgRoom.builder().roomId(name).build();
        msgRoomMap.put(room.getRoomId(), room);
        return room;
    }
}