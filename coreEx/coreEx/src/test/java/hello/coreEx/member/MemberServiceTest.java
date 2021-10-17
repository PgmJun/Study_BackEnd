package hello.coreEx.member;

import hello.coreEx.repository.MemberRepository;
import hello.coreEx.repository.MemoryMemberRepository;
import hello.coreEx.service.MemberService;
import hello.coreEx.service.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberRepository memberRepository = new MemoryMemberRepository();
    MemberService memberService = new MemberServiceImpl(memberRepository);

    @Test
    void join(){
        //given
        Member member = new Member(1L, "choi", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        System.out.println(findMember);
        Assertions.assertEquals(findMember, member);
    }
}
