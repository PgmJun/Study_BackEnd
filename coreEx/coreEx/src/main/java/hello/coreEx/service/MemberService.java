package hello.coreEx.service;

import hello.coreEx.member.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
