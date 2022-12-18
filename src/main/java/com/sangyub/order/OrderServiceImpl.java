package com.sangyub.order;

import com.sangyub.discount.DiscountPolicy;
import com.sangyub.discount.FixDiscountPolicy;
import com.sangyub.member.Member;
import com.sangyub.member.MemberRepository;
import com.sangyub.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private  MemberRepository memberRepository;
    private  DiscountPolicy discountPolicy;
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
