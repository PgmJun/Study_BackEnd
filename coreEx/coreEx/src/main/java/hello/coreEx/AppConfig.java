package hello.coreEx;

import hello.coreEx.discount.DiscountPolicy;
import hello.coreEx.discount.RateDiscountPolicy;
import hello.coreEx.order.OrderService;
import hello.coreEx.order.OrderServiceImpl;
import hello.coreEx.repository.MemberRepository;
import hello.coreEx.repository.MemoryMemberRepository;
import hello.coreEx.service.MemberService;
import hello.coreEx.service.MemberServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(discountPolicy(), memberRepository());
    }
}
