package com.javaTutorial.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity//테이블에 링크될 클래스임을 나타냄
public class Post {

    @Id//pk field임을 나타냄
    @GeneratedValue(strategy= GenerationType.IDENTITY)//pk 생성 규칙, identity=auto increment
    private Long id;

    @Column(length=20, nullable=false) //column 은 굳이 사용하지 않아도 ok, 추가 변경 옵션이 있으면 사용
    private String user;

    @Column(nullable = false)
    private String img;

    @Column(nullable = false)
    private String location;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String description;

    @Builder
    public Post(String user, String img, String location, String description){
        this.user=user;
        this.img=img;
        this.location=location;
        this.description=description;
    }
}
