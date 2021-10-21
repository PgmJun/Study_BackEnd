package hello.coreEx.singleton;

import hello.coreEx.AutoAppConfig;
import hello.coreEx.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

    @Test
    @DisplayName("AutoAppConfig에서 꺼낸 MemberRepository 2개가 싱글톤이 적용된 하나의 객체인지 확인")
    void singletonMemberRepository(){
        MemberRepository memberRepository1 = ac.getBean(MemberRepository.class);
        MemberRepository memberRepository2 = ac.getBean(MemberRepository.class);

        System.out.println("memberRepository1 = " + memberRepository1);
        System.out.println("memberRepository2 = " + memberRepository2);
        assertThat(memberRepository1).isSameAs(memberRepository2);

    }
}
