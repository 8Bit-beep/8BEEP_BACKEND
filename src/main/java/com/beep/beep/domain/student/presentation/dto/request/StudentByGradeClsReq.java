package com.beep.beep.domain.student.presentation.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentByGradeClsReq {

    private Integer grade;
    private Integer cls;

}
