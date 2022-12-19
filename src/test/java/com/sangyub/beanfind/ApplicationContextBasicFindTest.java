package com.sangyub.beanfind;

import com.sangyub.AppConfig;
import com.sangyub.member.MemberService;
import com.sangyub.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름 조회")
    void findByBeanName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService.getClass()).isEqualTo(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로 조회")
    void findBeanByType(){
        MemberService memberService = ac.getBean( MemberService.class);
        Assertions.assertThat(memberService.getClass()).isEqualTo(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findByBeanName2(){
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
        Assertions.assertThat(memberService.getClass()).isEqualTo(MemberServiceImpl.class);
    }


    @Test
    @DisplayName("xxxx 명칭 조회")
    void findByBeanNamexxxx(){

        assertThrows(NoSuchBeanDefinitionException.class,
                ()->ac.getBean("xxxx",MemberServiceImpl.class));
    }
}
