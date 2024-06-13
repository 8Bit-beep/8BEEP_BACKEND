package com.beep.beep.domain.beep.domain.repository.querydsl;

import com.beep.beep.domain.beep.presentation.dto.RoomVO;
import com.beep.beep.domain.beep.presentation.dto.request.FloorRoomReq;
import com.beep.beep.domain.beep.presentation.dto.response.RoomByFloorRes;

import java.util.List;

public interface RoomRepoCustom {

    List<RoomVO> roomListByName(String name);

    List<RoomByFloorRes> roomListByFloor(FloorRoomReq req);

}

