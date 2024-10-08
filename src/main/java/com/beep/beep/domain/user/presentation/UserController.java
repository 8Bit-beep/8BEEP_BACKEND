package com.beep.beep.domain.user.presentation;


import com.beep.beep.domain.user.presentation.dto.request.ChangePwReq;
import com.beep.beep.domain.user.presentation.dto.response.UserIdRes;
import com.beep.beep.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/users")
@RequiredArgsConstructor
@Tag(name = "유저", description = "유저 API")
public class UserController {

    private final UserService userService;

    @DeleteMapping("")
    @Operation(summary = "회원탈퇴", description = "회원탈퇴 요청합니다. (student,teacher,admin)")
    public void withdrawal(){
        userService.withdrawal();
    }

    @GetMapping("/find-user")
    @Operation(summary = "이메일-유저아이디에 일치하는 유저존재여부 조회", description = "이메일-유저아이디에 일치하는 유저가 존재하는지를 조회합니다.(unauthenticated)")
    public void checkIdEmail(
            @RequestParam String email,
            @RequestParam String id
    ) {
        userService.checkIdEmail(id,email);
    }

    @PutMapping("/change-pw")
    @Operation(summary = "비밀번호 변경", description = "아이디와 변경할 비번 값을 받아 비번을 변경해줍니다.(unauthenticated)")
    public void changePw(
            @RequestBody ChangePwReq request
    ) {
        userService.changePw(request);
    }

    @GetMapping("/find-id")
    @Operation(summary = "아이디 찾기", description = "검증된 이메일로 아이디를 찾습니다. (unauthenticated)")
    public UserIdRes findId(
            @RequestParam String email
    ){
        return userService.findId(email);
    }

    @GetMapping("/id-check")
    @Operation(summary = "아이디 확인", description = "아이디 존재여부 확인 (unauthenticated)")
    public ResponseEntity<Map<String, String>> studentIdCheck(
            @RequestParam String id
    ) {
        userService.idCheck(id);
        Map<String, String> response = new HashMap<>();
        response.put("status", "200");
        response.put("message","사용할 수 있는 아이디입니다.");
        return ResponseEntity.ok(response);
    }

}
