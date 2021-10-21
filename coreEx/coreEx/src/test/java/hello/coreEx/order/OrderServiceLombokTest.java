package hello.coreEx.order;

import hello.coreEx.AutoAppConfig;
import hello.coreEx.member.Grade;
import hello.coreEx.member.Member;
import hello.coreEx.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import static org.assertj.core.api.Assertions.assertThat;

public class OrderServiceLombokTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

    @Test
    void PrintDiscountType(){
        MemberRepository memberRepository = ac.getBean(MemberRepository.class);
        OrderService orderService = ac.getBean(OrderServiceImpl.class);

        Long memberId = 1L;
        Member member = new Member(memberId,"name", Grade.VIP);
        memberRepository.save(member);

        Order itemA = orderService.createOrder(memberId, "itemA", 20000);
        int discountPrice = itemA.getDiscountPrice();

        assertThat(discountPrice).isEqualTo(2000);

        Order itemB = orderService.createOrder(memberId, "itemB", 30000);
        int discountPrice1 = itemB.getDiscountPrice();

        assertThat(discountPrice1).isEqualTo(3000);
    }

    @Test
    @DisplayName("내가 등록한 빈 불러오기")
    void FindAllBean(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                System.out.println("beanDefinition = " + beanDefinition);
            }
        }

    }
}
