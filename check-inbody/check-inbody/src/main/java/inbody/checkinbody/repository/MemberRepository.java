package inbody.checkinbody.repository;

import inbody.checkinbody.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {
    Member save(Member member);
    List<Member> findRecord();

}
