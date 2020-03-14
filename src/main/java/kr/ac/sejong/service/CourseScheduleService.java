package kr.ac.sejong.service;

import kr.ac.sejong.domain.courseSchedule.CourseSchedule;
import kr.ac.sejong.domain.courseSchedule.CourseScheduleRepository;
import kr.ac.sejong.web.dto.excel.ExcelDto;
import kr.ac.sejong.web.dto.excel.CourseScheduleExcelDto;
import kr.ac.sejong.web.dto.courseschedule.CourseScheduleRequestDto;
import kr.ac.sejong.web.dto.courseschedule.CourseScheduleResponseDto;
import kr.ac.sejong.web.dto.courseschedule.CourseScheduleSelectResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Log
public class CourseScheduleService {

    private final CourseScheduleRepository courseScheduleRepository;

    @Transactional
    public Long save(CourseScheduleRequestDto requestDto) {
        return courseScheduleRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long saveCourseScheduleWithSubject(MultipartFile multipartFile) throws IOException {
        ExcelDto excelDto = new ExcelDto(multipartFile);

        CourseScheduleRequestDto courseScheduleRequestDto = CourseScheduleRequestDto.builder()
                .name(excelDto.getFileName())
                .courses(
                        excelDto.toCourseScheduleExcelDtos().stream()
                                .map(CourseScheduleExcelDto::toSubjectDto)
                                .distinct()
                                .collect(Collectors.toList())
                )
                .build();

        return courseScheduleRepository.save(courseScheduleRequestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, CourseScheduleRequestDto requestDto) {
        CourseSchedule courseSchedule = courseScheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Exception id = " +id));

        courseSchedule.update(requestDto.getName());

        return id;
    }

    @Transactional
    public void delete(Long id) {
        CourseSchedule courseSchedule = courseScheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Exception id = " +id));

        courseScheduleRepository.deleteById(1L);
    }

    @Transactional(readOnly = true)
    public List<CourseScheduleResponseDto> findAll() {
        return courseScheduleRepository.findAll().stream()
                .map(CourseScheduleResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CourseScheduleResponseDto findById(Long id) {
        CourseSchedule courseSchedule = courseScheduleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Exception id = " +id));

        return new CourseScheduleResponseDto(courseSchedule);
    }

    @Transactional(readOnly = true)
    public List<CourseScheduleSelectResponseDto> select() {
        return courseScheduleRepository.findAll().stream()
                .map(CourseScheduleSelectResponseDto::new)
                .collect(Collectors.toList());
    }
}
