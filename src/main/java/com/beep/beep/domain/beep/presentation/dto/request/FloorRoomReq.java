package com.beep.beep.domain.beep.presentation.dto.request;

import com.beep.beep.global.common.dto.request.PageRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FloorRoomReq extends PageRequest {

    private Integer floor;

}
