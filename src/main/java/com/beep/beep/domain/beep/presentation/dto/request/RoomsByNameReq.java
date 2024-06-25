package com.beep.beep.domain.beep.presentation.dto.request;

import com.beep.beep.global.common.dto.request.PageRequest;
import lombok.Getter;

@Getter
public class RoomsByNameReq extends PageRequest {
    private String name;
}
