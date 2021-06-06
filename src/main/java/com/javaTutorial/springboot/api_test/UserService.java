package com.javaTutorial.springboot.api_test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public String save(UserSaveRequestDto requestDto){
        return userRepository.save(requestDto.toEntity()).getId()+" : Success!!";
    }
}
