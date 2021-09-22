package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //Optional: 받은 변수가 NULL값일때 그 값을 감싸주는 것
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
