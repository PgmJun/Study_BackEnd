package inbody.checkinbody;


import inbody.checkinbody.repository.MemberRepository;
import inbody.checkinbody.repository.MemoryMemberRepository;
import inbody.checkinbody.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Bean
    MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }



}
