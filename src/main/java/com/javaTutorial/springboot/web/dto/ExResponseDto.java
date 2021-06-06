package com.javaTutorial.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter//선언된 모든 필드의 get 메소드 생성
@RequiredArgsConstructor//선언된 모든 final 필드가 포함된 생성자를 만들어줌
public class ExResponseDto {
    private final String dev_front;
    private final String dev_back;
    private final String project_name;
    private final String company;
    private final int grade;


}
