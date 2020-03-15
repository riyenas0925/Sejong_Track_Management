package kr.ac.sejong.web.dto.trackcourse;

import kr.ac.sejong.domain.trackcourse.TrackCourse;
import kr.ac.sejong.web.dto.course.CourseResponseDto;
import kr.ac.sejong.web.dto.track.TrackResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TrackCourseDto {
    private Long id;
    private TrackCourse.Type courseType;
    private TrackResponseDto track;
    private CourseResponseDto course;

    @Builder
    public TrackCourseDto(Long id, TrackCourse.Type courseType, TrackResponseDto track, CourseResponseDto course) {
        this.id = id;
        this.courseType = courseType;
        this.track = track;
        this.course = course;
    }
}
