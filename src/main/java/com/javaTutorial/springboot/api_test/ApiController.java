package com.javaTutorial.springboot.api_test;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final UserService userservice;

    @PostMapping("/api/test/user")
    public String save(@RequestBody UserSaveRequestDto requestDto){
        return userservice.save(requestDto);
    }

    @RequestMapping(value="/api/test", method= RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public String getApiTest(){

        return "{\"result\" : \"ok\" }";
    }

}
