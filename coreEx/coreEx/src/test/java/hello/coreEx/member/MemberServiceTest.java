package hello.coreEx.member;

import hello.coreEx.AppConfig;
import hello.coreEx.repository.MemberRepository;
import hello.coreEx.repository.MemoryMemberRepository;
import hello.coreEx.service.MemberService;
import hello.coreEx.service.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberServiceTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    void join(){
        MemberService memberService = ac.getBean(MemberService.class);

        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "name", Grade.VIP);


        //when
        memberService.join(member);
        Member findMember = memberService.findMember(memberId);

        //then
        Assertions.assertEquals(memberId, findMember.getId());

    }
}
