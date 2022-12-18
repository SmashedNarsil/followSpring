package com.sangyub.discount;

import com.sangyub.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
