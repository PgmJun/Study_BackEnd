package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest //스프링 컨테이너와 테스트를 함께 실행한다
@Transactional  //테스트 시작전에 Transactional을 걸어두면 테스트가 끝나면 테스트 전으로 DB롤백(다음 테스트에 영향을 주지 않게 해줌)
class MemberServiceIntegrationTest {

    @Autowired
    MemberService memberservice;
    @Autowired
    MemberRepository memberRepository;


    @Test
    public void 회원가입() throws Exception {
        //Given
        Member member = new Member();
        member.setName("hello");
        //When
        Long saveId = memberservice.join(member);
        //Then
        Member findMember = memberRepository.findById(saveId).get();
        assertEquals(member.getName(), findMember.getName());
    }

    //이미 존재하는 회원의 이름이 또 회원가입하려는 경우
    @Test
    public void 중복_회원_예외() throws Exception {
        //Given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");
        //When
        memberservice.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberservice.join(member2));//예외가 발생해야 한다.
        assertEquals(e.getMessage(),"이미 존재하는 회원입니다.");
    }
}