package kr.ac.sejong.web.dto.trackjudge;

import kr.ac.sejong.web.dto.trackcourse.TrackCourseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@RequiredArgsConstructor
@ToString
@Getter
public class CourseStatisticDto {
    private List<TrackCourseDto> trackCourseDtos;
    private Long sumCredit;

    @Builder
    public CourseStatisticDto(List<TrackCourseDto> trackCourseDtos, Long sumCredit) {
        this.trackCourseDtos = trackCourseDtos;
        this.sumCredit = sumCredit;
    }
}