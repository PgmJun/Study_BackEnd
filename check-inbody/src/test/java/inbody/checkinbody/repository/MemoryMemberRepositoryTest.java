package inbody.checkinbody.repository;

import inbody.checkinbody.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.verification.After;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    public void AfterEach(){
        memberRepository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member();
        member.setName("spring1");
        memberRepository.save(member);

        Member member2 = new Member();
        member.setName("spring2");
        memberRepository.save(member);
    }

    @Test
    void findRecord() {
        Member member = new Member();
        member.setName("spring1");
        memberRepository.save(member);

        Member member2 = new Member();
        member.setName("spring2");
        memberRepository.save(member2);

        List<Member> arr = memberRepository.findRecord();
        Assertions.assertEquals(arr.size(), 2);
    }
}