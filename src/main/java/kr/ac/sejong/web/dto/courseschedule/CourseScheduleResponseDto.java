package kr.ac.sejong.web.dto.courseschedule;

import kr.ac.sejong.domain.courseSchedule.CourseSchedule;
import kr.ac.sejong.web.dto.SubjectResponseDto;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
public class CourseScheduleResponseDto {
    private Long id;
    private String name;
    private List<SubjectResponseDto> subjects;

    public CourseScheduleResponseDto(CourseSchedule entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.subjects = entity.getSubjects().stream()
                .map(SubjectResponseDto::new)
                .collect(Collectors.toList());
    }
}
