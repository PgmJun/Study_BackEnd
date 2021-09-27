package inbody.checkinbody.service;

import inbody.checkinbody.domain.Member;
import inbody.checkinbody.repository.MemberRepository;
import inbody.checkinbody.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
public class MemberService {

    private MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    public void join(Member member){
        memberRepository.save(member);
    }

    public List<Member> findRecords(){
        return memberRepository.findRecord();
    }
}
