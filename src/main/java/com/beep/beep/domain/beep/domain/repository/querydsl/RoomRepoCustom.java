package com.beep.beep.domain.beep.domain.repository.querydsl;

import com.beep.beep.domain.beep.presentation.dto.RoomVO;
import com.beep.beep.domain.beep.presentation.dto.request.RoomsByFloorReq;
import com.beep.beep.domain.beep.presentation.dto.request.RoomsByNameReq;
import com.beep.beep.domain.beep.presentation.dto.response.RoomByFloorRes;

import java.util.List;

public interface RoomRepoCustom {

    List<RoomVO> roomListByName(RoomsByNameReq req);

    List<RoomByFloorRes> roomListByFloor(RoomsByFloorReq req);

}

