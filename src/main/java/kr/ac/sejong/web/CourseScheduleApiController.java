package kr.ac.sejong.web;

import kr.ac.sejong.service.CourseScheduleService;
import kr.ac.sejong.web.dto.courseschedule.CourseScheduleResponseDto;
import kr.ac.sejong.web.dto.courseschedule.CourseScheduleSelectResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Log
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin/courseSchedule/*")
public class CourseScheduleApiController {

    private final CourseScheduleService courseScheduleService;

    @PostMapping("/save")
    public void save(MultipartFile file) throws IOException {
        courseScheduleService.saveCourseScheduleWithSubject(file);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(Long id) {
        courseScheduleService.delete(id);
    }

    @GetMapping("/list")
    public List<CourseScheduleResponseDto> findAll() {
        return courseScheduleService.findAll();
    }

    @GetMapping("/list/{id}")
    public CourseScheduleResponseDto findById(@PathVariable Long id) {
        return courseScheduleService.findById(id);
    }

    @GetMapping("/select")
    public List<CourseScheduleSelectResponseDto> select() {
        return courseScheduleService.select();
    }
}
