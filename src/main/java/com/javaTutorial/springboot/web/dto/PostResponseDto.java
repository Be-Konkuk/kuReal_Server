package com.javaTutorial.springboot.web.dto;

import com.javaTutorial.springboot.domain.posts.Post;
import lombok.Getter;

@Getter
public class PostResponseDto {
    private Long id;
    private String user;
    private String img;
    private String location;
    private String description;

    public PostResponseDto(Post entity){
        this.id=entity.getId();
        this.user=entity.getUser();
        this.img=entity.getImg();
        this.location=entity.getLocation();
        this.description=entity.getDescription();
    }
}

