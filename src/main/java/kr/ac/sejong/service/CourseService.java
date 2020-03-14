package kr.ac.sejong.service;

import kr.ac.sejong.domain.course.Course;
import kr.ac.sejong.domain.course.CourseRepository;
import kr.ac.sejong.web.dto.course.CourseRequestDto;
import kr.ac.sejong.web.dto.course.CourseResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log
public class CourseService {

    private final CourseRepository courseRepository;

    @Transactional
    public Long save(CourseRequestDto requestDto) {
        return courseRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public void delete(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Exception id = " +id));

        courseRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<CourseResponseDto> findAll() {
        return courseRepository.findAll().stream()
                .map(CourseResponseDto::new)
                .collect(Collectors.toList());
    }

}
