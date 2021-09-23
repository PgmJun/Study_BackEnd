package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberservice;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberservice = new MemberService(memberRepository);
    }

    @AfterEach  //메소드가 실행이 끝날때마다 어떤 동작을 하게하는 것
    public void afterEach(){
        memberRepository.clearStore();
    }

    //이미 존재하는 회원의 이름이 또 회원가입하려는 경우
    @Test
    void 회원가입(){
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberservice.join(member);

        //then
        Member findMember = memberservice.findOne(saveId).get();
        Assertions.assertEquals(member.getName(),findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberservice.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberservice.join(member2));

        Assertions.assertEquals(e.getMessage(),"이미 존재하는 회원입니다.");



//        try{
//            memberservice.join(member2);
//            fail();
//        }catch(IllegalStateException e) {
//            Assertions.assertEquals(e.getMessage(),"이미 존재하는 회원입니다.");
//        }



        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}