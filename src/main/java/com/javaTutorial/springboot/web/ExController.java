package com.javaTutorial.springboot.web;

import com.javaTutorial.springboot.web.dto.ExResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // controller 를 json 을 반환하는 컨트롤러로 만들어줌 , @ResponseBody들을 합친 거라고 생각하면 됨
public class ExController {

    @GetMapping("/basicInfo")
    public String basicInfo(){
        return "Basic Information";
    }

    @GetMapping("/basicInfo/dto")
    public String exDto(@RequestParam("dev_front") String dev_front,
                               @RequestParam("dev_back") String dev_back,
                               @RequestParam("project_name") String project_name,
                               @RequestParam("company") String company,
                               @RequestParam("grade") int grade){
        //@RequestParam : 외부에서 api 로 넘긴 파라미터를 가져오는 어노테이션
        //dev_front 라는 이름으로 넘긴 파라미터를 메소드 파라미터 dev_f에 저장함
        //return new ExResponseDto(dev_front, dev_back, project_name, company, grade);
        return "Dev Front : "+dev_front+"\nDev Back : "+dev_back;
    }

}
