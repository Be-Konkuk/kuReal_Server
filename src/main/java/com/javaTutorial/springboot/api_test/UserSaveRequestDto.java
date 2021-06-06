package com.javaTutorial.springboot.api_test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {

    private int id;
    private String password;
    private String name;
    private String email;

    @Builder
    public UserSaveRequestDto(int id, String password, String name, String email){
        this.id=id;
        this.password=password;
        this.name=name;
        this.email=email;
    }

    public TestUser toEntity(){
        return TestUser.builder().id(id).password(password).name(name).email(email).build();
    }

}
