package hello.coreEx.repository;

import hello.coreEx.member.Member;

public interface MemberRepository {

    void save(Member member);
    Member findById(Long memberId);
}
