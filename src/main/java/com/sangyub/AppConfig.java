package com.sangyub;

import com.sangyub.discount.DiscountPolicy;
import com.sangyub.discount.FixDiscountPolicy;
import com.sangyub.member.MemberRepository;
import com.sangyub.member.MemberService;
import com.sangyub.member.MemberServiceImpl;
import com.sangyub.member.MemoryMemberRepository;
import com.sangyub.order.OrderService;
import com.sangyub.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }

}
