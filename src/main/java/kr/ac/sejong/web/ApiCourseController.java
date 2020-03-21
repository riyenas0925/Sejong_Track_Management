package kr.ac.sejong.web;

import kr.ac.sejong.service.CourseService;
import kr.ac.sejong.web.dto.course.CourseResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin/subject/*")
public class ApiCourseController {
    private final CourseService courseService;

    @DeleteMapping(path ="/delete/{id}")
    public void delete(Long id) {
        courseService.delete(id);
    }

    @GetMapping(path = "/list")
    public List<CourseResponseDto> findAll() {
        return courseService.findAll();
    }
}
