package com.beep.beep.domain.student.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder @AllArgsConstructor
public class StudentByGradeClsRes {

    private Long userIdx;

    private String name;

    private int num;

    private String floor;

    private String roomName;

}
