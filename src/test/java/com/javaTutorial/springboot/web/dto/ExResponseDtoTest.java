package com.javaTutorial.springboot.web.dto;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;//위에 junit 의 assertthat 보다는 얘가 더 좋음

public class ExResponseDtoTest {

    @Test
    public void 예제_api_테스트() {
        String dev_f = "jwRyu";
        String dev_b = "syJung";
        String projectName = "kuReal";
        String com = "Konkuk Univ.";
        int grade = 4;

        ExResponseDto dto = new ExResponseDto(dev_f, dev_b, projectName, com, grade);

        assertThat(dto.getDev_front()).isEqualTo(dev_f);
        assertThat(dto.getDev_back()).isEqualTo(dev_b);
        assertThat(dto.getProject_name()).isEqualTo(projectName);
        assertThat(dto.getCompany()).isEqualTo(com);
        assertThat(dto.getGrade()).isEqualTo(grade);

    }

}
