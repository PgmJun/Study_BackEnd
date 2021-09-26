package inbody.checkinbody.repository;

import inbody.checkinbody.domain.Member;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.*;

    public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static Long sequence = 0L;


    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }

    @Override
    public List<Member> findRecord() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
