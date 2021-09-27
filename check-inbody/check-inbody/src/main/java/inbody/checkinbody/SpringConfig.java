package inbody.checkinbody;


import inbody.checkinbody.repository.JpaMemberRepository;
import inbody.checkinbody.repository.MemberRepository;
import inbody.checkinbody.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    MemberRepository memberRepository(){
        return new JpaMemberRepository(em);
//        return new MemoryMemberRepository();
    }



}
