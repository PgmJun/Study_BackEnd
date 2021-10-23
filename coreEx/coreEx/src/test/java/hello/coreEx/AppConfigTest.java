package hello.coreEx;

import hello.coreEx.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class AppConfigTest {
    @Test
    void BeanLifeCycle(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        ac.getBean(MemberRepository.class);
        ac.close();
    }


}