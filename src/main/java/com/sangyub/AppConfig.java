package com.sangyub;

import com.sangyub.discount.FixDiscountPolicy;
import com.sangyub.member.MemberService;
import com.sangyub.member.MemberServiceImpl;
import com.sangyub.member.MemoryMemberRepository;
import com.sangyub.order.OrderService;
import com.sangyub.order.OrderServiceImpl;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
