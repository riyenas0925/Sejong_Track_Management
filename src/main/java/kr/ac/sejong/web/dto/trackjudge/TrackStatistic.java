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
public class TrackStatistic {
    private UnivResponseDto univ;
    private TrackResponseDto track;
    private Long totalCourseCredit;
    private Long totalRuleCredit;
    private Double percent;
    private String percentColor;
    private Map<TrackCourse.Type, Map<TrackJudge.PNP, CourseStatistic>> trackClassify;

    public TrackStatistic(TrackJudge entity) {
        this.univ = new UnivResponseDto(entity.getTrack().getUniv());
        this.track = new TrackResponseDto(entity.getTrack());
        this.totalCourseCredit = entity.getTotalCourseCredit();
        this.totalRuleCredit = entity.getTotalRuleCredit();
        this.percent = entity.getPercent();
        this.percentColor = entity.getPercentColor();
        this.trackClassify = entity.getTrackClassify();
    }
}
