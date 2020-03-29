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
public class CourseStatistic {
    private List<CourseResponseDto> Courses;
    private Long sumCredit;
    private Long ruleCredit;
    private Long minSumAndRuleCredit;
    private Double percent;

    @Builder
    public CourseStatistic(List<CourseResponseDto> Courses, Long sumCredit, Long ruleCredit) {
        this.Courses = Courses;
        this.sumCredit = sumCredit;
        this.ruleCredit = ruleCredit;
        this.minSumAndRuleCredit = Math.min(sumCredit, ruleCredit);
        this.percent = ruleCredit != 0 ? calcPercent(minSumAndRuleCredit, ruleCredit) : 0.0;
    }

    public  Double calcPercent(Long numerator, Long denominator) {
        return Double.valueOf(numerator) / Double.valueOf(denominator) * 100.0;
    }
}