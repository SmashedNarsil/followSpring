package com.sangyub.order;

import com.sangyub.AppConfig;
import com.sangyub.member.Grade;
import com.sangyub.member.Member;
import com.sangyub.member.MemberService;
import com.sangyub.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    MemberService memberService ;
    OrderService orderService ;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        this.memberService = appConfig.memberService();
        this.orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "MemberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}