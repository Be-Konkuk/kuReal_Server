package com.javaTutorial.springboot.web;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)//스프링부트 테스트와 JUnit 사이의 연결자 역할//테스트를 진행할 때 JUnit 에 내장된 실행자 외의 다른 실행자들을 실행시킴
@WebMvcTest//여러 스프링 테스트 어노ㅔ이션 중 Web에 집중// 선언할 경우, @Controller, @ControllerAdvice 등은 사용 가능// @Service, @Component, @Repository 등은 사용 불가
public class ExControllerTest {
/*
    @Autowired//스프링이 관리하는 bean 을 주입받음
    private MockMvc mvc; //웹 api 를 테스트할때 사용함
    //스프링 mvc 테스트의 시작점, 이 클래스를 통해 http get, post 등에 대한 api 를 테스트함

    @Test
    public void basicInfoRet() throws Exception{
        String basicInfo="Basic Information";

        mvc.perform(get("/basicInfo"))
                .andExpect(status().isOk())//http header 의 status 를 검증
                .andExpect(content().string(basicInfo));//mvc.perform의 결과를 검증
    }*/

}
