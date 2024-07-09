package com.beep.beep.domain.beep.presentation;

import com.beep.beep.domain.beep.presentation.dto.request.RoomsByFloorReq;
import com.beep.beep.domain.beep.presentation.dto.request.InitializeAttendanceReq;
import com.beep.beep.domain.beep.presentation.dto.request.RoomsByNameReq;
import com.beep.beep.domain.beep.presentation.dto.response.RoomByFloorRes;
import com.beep.beep.domain.beep.service.BeepService;
import com.beep.beep.domain.beep.presentation.dto.request.EnterRoomReq;
import com.beep.beep.domain.beep.presentation.dto.request.ExitRoomReq;
import com.beep.beep.domain.beep.presentation.dto.response.AttendanceByCodeRes;
import com.beep.beep.domain.beep.presentation.dto.RoomVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/beep")
@Tag(name = "BEEP", description = "출석,출석부 조회,실 조회 API")
public class BeepController {

    private final BeepService beepService;

    @PostMapping("/attendances")
    @Operation(summary = "출석정보 초기화", description = "출석정보 초기값을 설정합니다.(student)")
    public ResponseEntity<Map<String, String>> initializeAttendance(
            @RequestBody InitializeAttendanceReq request
    ) {
        beepService.initializeAttendance(request);
        Map<String, String> response = new HashMap<>();
        response.put("status", "201");
        response.put("message", "출석정보 저장에 성공했습니다.");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/enter")
    @Operation(summary = "입실 요청", description = "입실을 요청합니다.(student)")
    public ResponseEntity<Map<String, String>> enterRoom(
            @RequestBody EnterRoomReq request
    ) {
        beepService.enter(request);
        Map<String, String> response = new HashMap<>();
        response.put("status", "200");
        response.put("message","입실 요청이 성공했습니다.");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/exit")
    @Operation(summary = "퇴실 요청", description = "퇴실을 요청합니다.(student)")
    public ResponseEntity<Map<String, String>> exitRoom(
            @RequestBody ExitRoomReq request
    ) {
        beepService.exit(request);
        Map<String, String> response = new HashMap<>();
        response.put("status", "200");
        response.put("message","퇴실 요청이 성공했습니다.");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/rooms/name")
    @Operation(summary = "실 조회", description = "실 이름으로 실을 조회합니다.(teacher)")
    public ResponseEntity<List<RoomVO>> roomListByName(
            @ModelAttribute RoomsByNameReq req
    ){
        return ResponseEntity.ok().body(beepService.roomListByName(req));
    }

    @GetMapping("/rooms/floor")
    @Operation(summary = "실 조회", description = "n층으로 실을 조회합니다.(teacher)")
    public ResponseEntity<List<RoomByFloorRes>> roomListByFloor(
            @ModelAttribute RoomsByFloorReq req
    ){
        return ResponseEntity.ok().body(beepService.roomListByFloor(req));
    }

    @GetMapping("/attendances")
    @Operation(summary = "출석 조회", description = "실 코드로 입실한 학생목록 조회합니다. (teacher)")
    public ResponseEntity<List<AttendanceByCodeRes>> attendanceByCode(
            @RequestParam String code
    ){
        return ResponseEntity.ok().body(beepService.attendanceByCode(code));
    }

}
