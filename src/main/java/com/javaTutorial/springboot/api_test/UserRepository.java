package com.javaTutorial.springboot.api_test;

import com.javaTutorial.springboot.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<TestUser, Integer> {
}
