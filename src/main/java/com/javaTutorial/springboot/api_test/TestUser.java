package com.javaTutorial.springboot.api_test;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity

public class TestUser {
//    private String name;
//    private String email;
//    private String password;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(length=20, nullable = false)
    private String password;

    @Column(length=20, nullable = false)
    private String name;

    @Column(length=100)
    private String email;


    @Builder
    public TestUser(int id, String password, String name, String email){
        this.id=id;
        this.password=password;
        this.name=name;
        this.email=email;
    }
    public void update(String name, String email) {
        this.name=name;
        this.email=email;
    }



}
