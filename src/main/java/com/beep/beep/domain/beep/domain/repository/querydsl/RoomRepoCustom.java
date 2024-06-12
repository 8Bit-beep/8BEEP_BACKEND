package com.beep.beep.domain.beep.domain.repository.querydsl;

import com.beep.beep.domain.beep.presentation.dto.RoomVO;

import java.util.List;

public interface RoomRepoCustom {

    List<RoomVO> roomListByName(String name);

    List<RoomVO> roomListByFloor(Integer floor);

}

