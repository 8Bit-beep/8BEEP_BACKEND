package com.beep.beep.domain.beep.presentation.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder @AllArgsConstructor
public class AttendanceByCodeRes {

    private String userName;
    private Integer grade;
    private Integer cls;
    private Integer num;

}
