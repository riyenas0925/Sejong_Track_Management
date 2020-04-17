package kr.ac.sejong.web;

import kr.ac.sejong.service.JudgeLogService;
import kr.ac.sejong.web.dto.trackjudge.JudgeLogRequestDto;
import kr.ac.sejong.web.dto.trackjudge.JudgeLogResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/*")
public class ApiJudgeLogController {
    private final JudgeLogService service;

    @PostMapping("/log/update")
    public ResponseEntity<String> update(@RequestBody JudgeLogRequestDto reqDto)throws Exception{
        service.updateOrInsert(reqDto);    /**--> globalException으로 처리하는데 res entity는?**/
        ResponseEntity<String> entity = new ResponseEntity<>(HttpStatus.OK);
        return entity;
    }

    @GetMapping("/log/find1/{userId}")
    public ResponseEntity<List<JudgeLogResponseDto>> find(@PathVariable String userId) throws Exception {
        List<JudgeLogResponseDto> resDtos = service.findByMember(userId);
        ResponseEntity<List<JudgeLogResponseDto>> entity = new ResponseEntity<>(resDtos, HttpStatus.OK);
        return entity;
    }

    @GetMapping("/log/find2/{trackId}")
    public ResponseEntity<List<JudgeLogResponseDto>> find(@PathVariable Long trackId) throws Exception {
        List<JudgeLogResponseDto> resDtos = service.findByTrack(trackId);
        ResponseEntity<List<JudgeLogResponseDto>> entity = new ResponseEntity<>(resDtos, HttpStatus.OK);
        return entity;
    }

    @GetMapping("/admin/log/find/all")
    public ResponseEntity<List<JudgeLogResponseDto>> findAll() throws Exception {
        List<JudgeLogResponseDto> resDtos = service.findAllByDesc();
        ResponseEntity<List<JudgeLogResponseDto>> entity = new ResponseEntity<>(resDtos, HttpStatus.OK);
        return entity;
    }
}
