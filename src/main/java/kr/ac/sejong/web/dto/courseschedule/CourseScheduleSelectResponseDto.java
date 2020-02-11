package kr.ac.sejong.web.dto.courseschedule;

import kr.ac.sejong.domain.courseSchedule.CourseSchedule;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CourseScheduleSelectResponseDto {
    private Long id;
    private String name;

    public CourseScheduleSelectResponseDto(CourseSchedule entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }
}
