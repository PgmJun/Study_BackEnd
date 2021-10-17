package hello.coreEx.order;

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

class OrderServiceImplTest {

    MemberRepository memberRepository = new MemoryMemberRepository();
    MemberService memberService = new MemberServiceImpl(memberRepository);
    DiscountPolicy discountPolicy = new RateDiscountPolicy();
    OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "member", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA", 20000);
        Assertions.assertEquals(order.getDiscountPrice(), 2000);
    }

}