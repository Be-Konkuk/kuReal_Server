package com.javaTutorial.springboot.web.dto;

import com.javaTutorial.springboot.api_test.TestUser;
import com.javaTutorial.springboot.api_test.UserRepository;
import com.javaTutorial.springboot.api_test.UserSaveRequestDto;
import com.javaTutorial.springboot.domain.posts.Posts;
import com.javaTutorial.springboot.domain.posts.PostsRepository;
import com.javaTutorial.springboot.web.dto.PostsSaveRequestDto;
import com.javaTutorial.springboot.web.dto.PostsUpdateRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class UserTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

//    @After
//    public void tearDown() throws Exception{
//        userRepository.deleteAll();
//    }

    @Test
    public void User_등록된다() throws Exception{
        //given
        Long id = Long.valueOf(1);
        String password = "password";
        UserSaveRequestDto requestDto = UserSaveRequestDto.builder()
                .id(id)
                .password(password)
                .name("NAme")
                .email("000000@gmail.com")
                .build();

        String url = "http://localhost:"+port+"/api/test/user";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<TestUser> all = userRepository.findAll();
        assertThat(all.get(0).getId()).isEqualTo(id);
        assertThat(all.get(0).getPassword()).isEqualTo(password);
    }


}
