package com.javaTutorial.springboot.service;

import com.javaTutorial.springboot.domain.posts.Post;
import com.javaTutorial.springboot.domain.posts.PostRepository;
import com.javaTutorial.springboot.web.dto.PostResponseDto;
import com.javaTutorial.springboot.web.dto.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto rDto){
        return postRepository.save(rDto.toEntity()).getId();
    }

    @Transactional
    public PostResponseDto findById(Long id){
        Post entity = postRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("No Post with current ID : "+id));

        return new PostResponseDto(entity);
    }
}
