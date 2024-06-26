package com.beep.beep.domain.beep.domain.repository.querydsl;

import com.beep.beep.domain.beep.presentation.dto.response.AttendanceByCodeRes;
import com.beep.beep.domain.student.presentation.dto.response.StudentByUserRes;
import com.beep.beep.domain.user.presentation.dto.UserVO;

import java.util.List;

public interface AttendanceRepoCustom {

    List<AttendanceByCodeRes> attendanceListByCode(String code);

    StudentByUserRes studentByUser(UserVO userVO);

}
