package com.beep.beep.domain.student.presentation;


import com.beep.beep.domain.student.presentation.dto.request.StudentByGradeClsReq;
import com.beep.beep.domain.student.presentation.dto.request.SaveStudentIdReq;
import com.beep.beep.domain.student.presentation.dto.response.StudentRes;
import com.beep.beep.domain.student.presentation.dto.response.ClsByGradeRes;
import com.beep.beep.domain.student.presentation.dto.response.StudentByGradeClsRes;
import com.beep.beep.domain.student.presentation.dto.response.StudentByNameRes;
import com.beep.beep.domain.student.presentation.dto.response.StudentByUserRes;
import com.beep.beep.domain.student.service.StudentService;
import com.beep.beep.global.common.dto.request.PageRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
@Tag(name = "학생", description = "학생 조회 API")
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/id")
//    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "학번 저장", description = "학번을 저장합니다. (student)")
    public ResponseEntity<Map<String, String>> saveStudentId(
            @RequestBody SaveStudentIdReq req
    ){
        studentService.saveStudentId(req);
        Map<String, String> response = new HashMap<>();
        response.put("status", "201");
        response.put("message","학번 저장에 성공했습니다.");
        return ResponseEntity.ok(response);
    }

    @GetMapping("")
    @Operation(summary = "학생계정 조회", description = "학생계정 전부 조회합니다. (admin)")
    public List<StudentRes> studentList(
            @ModelAttribute PageRequest req
    ){
        return studentService.studentList(req);
    }

    @GetMapping("/info")
    @Operation(summary = "학생프로필 조회", description = "학생프로필 조회입니다 (student)")
    public StudentByUserRes studentByUser() {
        return studentService.studentByUser();
    }

    @GetMapping("/cls")
    @Operation(summary = "반 조회", description = "학년 param로 반을 조회합니다.(teacher)")
    public ResponseEntity<List<ClsByGradeRes>> clsListByGrade(
            @RequestParam int grade
    ){
        return ResponseEntity.ok(studentService.clsListByGrade(grade));
    }

    @GetMapping("/member")
    @Operation(summary = "반 구성원 조회", description = "학년-반으로 반 구성원 목록을 조회합니다. (teacher)")
    public ResponseEntity<List<StudentByGradeClsRes>> studentListByGradeCls(
            @ModelAttribute StudentByGradeClsReq req
    ){
        return ResponseEntity.ok(studentService.studentListByGradeCls(req));
    }

    @GetMapping("/name")
    @Operation(summary = "학생 조회", description = "학생이름으로 학생을 조회합니다.(teacher)")
    public ResponseEntity<List<StudentByNameRes>> studentListByName(
            @RequestParam String name
    ){
        return ResponseEntity.ok(studentService.studentListByName(name));
    }
  
}
