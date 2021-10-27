package hello.coreEx.order;

import hello.coreEx.AppConfig;
import hello.coreEx.discount.DiscountPolicy;
import hello.coreEx.discount.RateDiscountPolicy;
import hello.coreEx.member.Grade;
import hello.coreEx.member.Member;
import hello.coreEx.repository.MemberRepository;
import hello.coreEx.repository.MemoryMemberRepository;
import hello.coreEx.service.MemberService;
import hello.coreEx.service.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


    @Test
    void Order(){
        MemberRepository memberRepository = ac.getBean(MemberRepository.class);
        OrderService orderService = ac.getBean(OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "name", Grade.VIP);
        memberRepository.save(member);

        Order item = orderService.createOrder(memberId, "item", 20000);

        Assertions.assertEquals(item.getDiscountPrice(), 2000);

    }

}