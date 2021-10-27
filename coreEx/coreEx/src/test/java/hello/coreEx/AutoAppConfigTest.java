package hello.coreEx;

import hello.coreEx.member.Grade;
import hello.coreEx.member.Member;
import hello.coreEx.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class AutoAppConfigTest {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

    @Test
    void AutoConfig(){
        AutoAppConfig autoAppConfig = ac.getBean(AutoAppConfig.class);




    }

}