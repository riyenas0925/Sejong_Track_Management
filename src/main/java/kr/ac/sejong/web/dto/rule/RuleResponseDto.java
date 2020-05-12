package kr.ac.sejong.web.dto.rule;

import kr.ac.sejong.domain.notice.Notice;
import kr.ac.sejong.domain.rule.Rule;
import kr.ac.sejong.domain.trackcourse.TrackCourse;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

public class RuleResponseDto {
    private Long id;
    private Long credit;
    private TrackCourse.Type courseType;

    public RuleResponseDto(Rule rule) {
        this.id = rule.getId();
        this.credit = rule.getCredit();
        this.courseType = rule.getCourseType();
    }
}
