package kr.ac.sejong.web.dto.courseschedule;

import kr.ac.sejong.domain.courseSchedule.CourseSchedule;
import kr.ac.sejong.web.dto.course.CourseRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
public class CourseScheduleRequestDto {
    private String name;
    private List<CourseRequestDto> courses;

    @Builder
    public CourseScheduleRequestDto(String name, List<CourseRequestDto> courses) {
        this.name = name;
        this.courses = courses;
    }

    public CourseSchedule toEntity() {
        return CourseSchedule.builder()
                .name(name)
                .courses(courses.stream()
                        .map(CourseRequestDto::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }
}
