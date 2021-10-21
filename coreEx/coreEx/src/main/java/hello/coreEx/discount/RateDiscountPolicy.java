package hello.coreEx.discount;

import hello.coreEx.annotation.MainDiscountPolicy;
import hello.coreEx.member.Grade;
import hello.coreEx.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP)
            return (price/100)*discountPercent;
        else
            return 0;
    }
}