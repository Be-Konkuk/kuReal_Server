package com.javaTutorial.springboot.web.dto;

import com.javaTutorial.springboot.domain.posts.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {
    private String user;
    private String img;
    private String location;
    private String description;

    @Builder
    public PostSaveRequestDto(String user, String img, String location, String description){
        this.user=user;
        this.img=img;
        this.location=location;
        this.description=description;
    }

    public Post toEntity(){
        return Post.builder()
                .user(user)
                .img(img)
                .location(location)
                .description(description)
                .build();
    }
}
