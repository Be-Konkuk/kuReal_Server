package com.javaTutorial.springboot.web;

import com.javaTutorial.springboot.domain.posts.Post;
import com.javaTutorial.springboot.domain.posts.PostRepository;
import com.javaTutorial.springboot.web.dto.PostSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private PostRepository pRepo;

    @After
    public void tearDown() throws Exception{
        pRepo.deleteAll();
    }

    @Test
    public void Post_등록() throws Exception{
        String user = "Test User";
        String img = "testImg.png";
        String location = "Seoul Daejeon";
        String description = "this is a description";

        PostSaveRequestDto requestDto=PostSaveRequestDto.builder()
                .user(user)
                .img(img)
                .location(location)
                .description(description)
                .build();

        String url = "http://localhost:"+port+"api/post";

        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        List<Post> all = pRepo.findAll();
        assertThat(all.get(0).getUser()).isEqualTo(user);
        assertThat(all.get(0).getImg()).isEqualTo(img);
    }
}
