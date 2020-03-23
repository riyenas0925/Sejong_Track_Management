package kr.ac.sejong.web.dto.trackjudge;

import kr.ac.sejong.domain.trackJudge.TrackJudge;
import kr.ac.sejong.domain.trackcourse.TrackCourse;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.java.Log;

import java.util.Map;

@Getter
@ToString
@Log
public class TrackStatisticDto {
    private Double percent;
    private Long totalCourseCredit;
    private Long totalRuleCredit;
    private PercentColor percentColor;
    private Map<TrackCourse.Type, Map<TrackJudge.PNP, CourseStatisticDto>> trackJudge;

    public TrackStatisticDto(Map<TrackCourse.Type, Map<TrackJudge.PNP, CourseStatisticDto>> trackJudge) {
        this.trackJudge = trackJudge;
        this.totalCourseCredit = sumPassCourseCredit(trackJudge);
        this.totalRuleCredit = sumRuleCredit(trackJudge);
        this.percent = Double.valueOf(totalCourseCredit) / Double.valueOf(totalRuleCredit) * 100.0;
    }

    public Long sumPassCourseCredit(Map<TrackCourse.Type, Map<TrackJudge.PNP, CourseStatisticDto>> trackJudge){
        return trackJudge.entrySet().stream()
                .mapToLong(y -> {
                    return y.getValue().entrySet().stream()
                            .filter(l -> l.getKey().equals(TrackJudge.PNP.NON_PASS))
                            .mapToLong(k -> {
                                return k.getValue().getSumCredit();
                            }).sum();
                }).sum();
    }

    public Long sumRuleCredit(Map<TrackCourse.Type, Map<TrackJudge.PNP, CourseStatisticDto>> trackJudge){
        return trackJudge.entrySet().stream()
                .mapToLong(y -> {
                    return y.getValue().entrySet().stream()
                            .filter(l -> l.getKey().equals(TrackJudge.PNP.NON_PASS))
                            .mapToLong(k -> {
                                return k.getValue().getRuleCredit();
                            }).sum();
                }).sum();
    }

    public enum PercentColor{
        GREEN("#2dce89", "80~100%"),
        BLUE("#11cdef", "50~79%"),
        ORANGE("#fb6340", "30~49%"),
        RED("#f5365c", "0~29%");

        private String hex;
        private String text;

        PercentColor(String hex, String text){
            this.hex = hex;
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public String getHex() {
            return hex;
        }
    }
}
