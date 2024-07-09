package com.beep.beep.domain.beep.presentation.dto;


import com.beep.beep.global.common.dto.request.PageRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder @AllArgsConstructor
public class RoomVO {
    private String code;
    private Integer floor;
    private String name;
}
