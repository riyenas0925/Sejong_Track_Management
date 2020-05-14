package kr.ac.sejong.web.dto.trackjudge;

import kr.ac.sejong.domain.trackJudge.TrackJudge;
import kr.ac.sejong.domain.trackcourse.TrackCourse;
import kr.ac.sejong.web.dto.track.TrackResponseDto;
import kr.ac.sejong.web.dto.univ.UnivResponseDto;
import lombok.Getter;
import lombok.ToString;

import java.util.Map;

@Getter
@ToString
public class TrackStatisticSummary {
    private UnivResponseDto univ;
    private TrackResponseDto track;
    private Long totalCourseCredit;
    private Long totalRuleCredit;
    private TrackJudge.PNP pnp;
    private Double percent;
    private String percentColor;

    public TrackStatisticSummary(TrackJudge entity) {
        this.univ = new UnivResponseDto(entity.getTrack().getUniv());
        this.track = new TrackResponseDto(entity.getTrack());
        this.totalCourseCredit = entity.getTotalCourseCredit();
        this.totalRuleCredit = entity.getTotalRuleCredit();
        this.percent = entity.getPercent();
        this.pnp = entity.getPnp();
        this.percentColor = entity.getPercentColor();
    }
}
