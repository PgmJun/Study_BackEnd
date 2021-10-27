package hello.coreEx.discount;

import hello.coreEx.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);

}
