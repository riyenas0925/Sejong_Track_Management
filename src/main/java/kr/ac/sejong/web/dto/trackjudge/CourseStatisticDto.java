package kr.ac.sejong.web.dto.trackjudge;

import kr.ac.sejong.domain.trackcourse.TrackCourse;
import kr.ac.sejong.web.dto.course.CourseResponseDto;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;

@RequiredArgsConstructor
@ToString
@Getter
public class CourseStatisticDto {
    private List<CourseResponseDto> Courses;
    private Long sumCredit;
    private Long ruleCredit;
    private Double percent;

    @Builder
    public CourseStatisticDto(List<CourseResponseDto> Courses, Long sumCredit, Long ruleCredit) {
        this.Courses = Courses;
        this.sumCredit = sumCredit;
        this.ruleCredit = ruleCredit;
        this.percent = Double.valueOf(sumCredit) / Double.valueOf(ruleCredit) * 100.0;
    }
}