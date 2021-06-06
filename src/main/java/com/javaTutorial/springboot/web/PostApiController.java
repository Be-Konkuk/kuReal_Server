package com.javaTutorial.springboot.web;

import com.javaTutorial.springboot.service.PostService;
import com.javaTutorial.springboot.web.dto.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;

    @PostMapping("/api/post")
    public Long save(@RequestBody PostSaveRequestDto rDto){
        return postService.save(rDto);
        //return "ID : "+postService.save(rDto)+" saved!";
    }

    @GetMapping("/api/post/{id}")
    public PostResponseDto findById(@PathVariable Long id){
        return postService.findById(id);
    }
}
