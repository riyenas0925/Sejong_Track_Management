package kr.ac.sejong.web.dto.trackcourse;

import kr.ac.sejong.domain.trackcourse.TrackCourse;
import kr.ac.sejong.web.dto.course.CourseResponseDto;
import kr.ac.sejong.web.dto.track.TrackResponseDto;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TrackCourseResponseDto {
    private Long id;
    private TrackCourse.Type courseType;
    private TrackResponseDto track;
    private CourseResponseDto course;

    public TrackCourseResponseDto(TrackCourse entity) {
        this.id = entity.getId();
        this.courseType = entity.getCourseType();
        this.course = new CourseResponseDto(entity.getCourse());
        this.track = new TrackResponseDto(entity.getTrack());
    }
}
