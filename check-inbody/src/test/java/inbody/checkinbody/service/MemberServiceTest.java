package inbody.checkinbody.service;

import inbody.checkinbody.domain.Member;
import inbody.checkinbody.repository.MemberRepository;
import inbody.checkinbody.repository.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberRepository memberRepository = new MemoryMemberRepository();
    MemberService memberService = new MemberService(memberRepository);

    @Test
    void join() {
        Member member = new Member();
        member.setDate("2222년 2월 22일");
        member.setGender("male");
        member.setName("최승준");
        member.setAge(22);
        member.setHeight(178);
        member.setWeight(64.8);
        member.setRmr(1784.2);

        memberService.join(member);
    }

    @Test
    void findRecords() {
        Member member = new Member();
        member.setDate("2222년 2월 22일");
        member.setGender("male");
        member.setName("최승준");
        member.setAge(22);
        member.setHeight(178);
        member.setWeight(64.8);
        member.setRmr(1784.2);

        memberService.join(member);

        Member member2 = new Member();
        member2.setDate("2222년 2월 22일");
        member2.setGender("male");
        member2.setName("최승호");
        member2.setAge(23);
        member2.setHeight(182);
        member2.setWeight(75);
        member2.setRmr(1874.2);

        memberService.join(member2);

        List<Member> list = memberService.findRecords();

        Assertions.assertEquals(list.size(), 2);
    }
}