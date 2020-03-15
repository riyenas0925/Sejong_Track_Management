package kr.ac.sejong.web.dto.courseschedule;

import kr.ac.sejong.domain.courseSchedule.CourseSchedule;
import kr.ac.sejong.web.dto.course.CourseResponseDto;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
public class CourseScheduleResponseDto {
    private Long id;
    private String name;
    private List<CourseResponseDto> courses;

    public CourseScheduleResponseDto(CourseSchedule entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.courses = entity.getCourses().stream()
                .map(CourseResponseDto::new)
                .collect(Collectors.toList());
    }
}
