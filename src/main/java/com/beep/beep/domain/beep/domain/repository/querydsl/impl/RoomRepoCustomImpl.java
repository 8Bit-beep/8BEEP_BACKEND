package com.beep.beep.domain.beep.domain.repository.querydsl.impl;


import com.beep.beep.domain.beep.domain.repository.querydsl.RoomRepoCustom;
import com.beep.beep.domain.beep.presentation.dto.RoomVO;
import com.beep.beep.domain.beep.presentation.dto.request.RoomsByFloorReq;
import com.beep.beep.domain.beep.presentation.dto.request.RoomsByNameReq;
import com.beep.beep.domain.beep.presentation.dto.response.RoomByFloorRes;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import static com.beep.beep.domain.beep.domain.QRoom.room;

@Repository
@RequiredArgsConstructor
public class RoomRepoCustomImpl implements RoomRepoCustom {

    private final JPAQueryFactory query;

    @Override
    public List<RoomVO> roomListByName(RoomsByNameReq req) {
        return query.select(Projections.constructor(RoomVO.class,
                        room.code,
                        room.floor,
                        room.name))
                .from(room)
                .where(room.name.contains(req.getName()))
                .offset((req.getPage() - 1) * req.getSize())
                .fetch();
    }

    @Override
    public List<RoomByFloorRes> roomListByFloor(RoomsByFloorReq req) {
        return query.select(Projections.constructor(RoomByFloorRes.class,
                room.idx,
                room.code,
                room.name))
                .from(room)
                .where(room.floor.eq(req.getFloor()))
                .offset((req.getPage() - 1) * req.getSize())
                .limit(req.getSize())
                .orderBy(room.idx.asc())
                .fetch();
    }

}
