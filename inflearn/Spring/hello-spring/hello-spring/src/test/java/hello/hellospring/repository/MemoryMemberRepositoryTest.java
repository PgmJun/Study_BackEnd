package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();


    @AfterEach  //메소드가 실행이 끝날때마다 어떤 동작을 하게하는 것
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(member,result); //Assertions는 비교해주는 함수
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("string1");
        repository.save(member1);

        Member member2 = new Member();
        member1.setName("string1");
        repository.save(member2);

        Member result = repository.findByName("string1").get();

        Assertions.assertEquals(member1, result);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("string1");
        repository.save(member1);

        Member member2 = new Member();
        member1.setName("string1");
        repository.save(member2);

        Member member3 = new Member();
        member1.setName("string1");
        repository.save(member3);

        List<Member> result = repository.findAll();

        Assertions.assertEquals(result.size(),3);
    }



}
