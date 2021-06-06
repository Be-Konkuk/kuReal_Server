package com.javaTutorial.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest //이거 쓰면 H2 데이터베이스 테스트 자동으로 해줌
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @After//JUnit에서 단위테스트가 끝날떄마다 수행할 메소드 지정
    public void cleanup(){
        postRepository.deleteAll();
    }

    @Test
    public void post저장_확인(){
        String user="Test User";
        String img = "testImg.png";
        String location = "location!";
        String description="this is a test description";

        postRepository.save(Post.builder().user(user)
                .img(img)
                .location(location)
                .description(description)
                .build());

        List<Post> postList = postRepository.findAll();

        Post post = postList.get(0);
        assertThat(post.getUser()).isEqualTo(user);
        assertThat(post.getImg()).isEqualTo(img);
        assertThat(post.getDescription()).isEqualTo(description);
        assertThat(post.getLocation()).isEqualTo(location);
    }
}
