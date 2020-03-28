package kr.ac.sejong.web.dto.trackjudge;

import kr.ac.sejong.domain.trackJudge.TrackJudge;
import kr.ac.sejong.domain.trackcourse.TrackCourse;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.java.Log;

import java.util.Arrays;
import java.util.Map;

@Getter
@ToString
@Log
public class TrackStatisticDto {
    private Double percent;
    private Long totalCourseCredit;
    private Long totalRuleCredit;
    private String percentColor;
    private Map<TrackCourse.Type, Map<TrackJudge.PNP, CourseStatisticDto>> trackJudge;

    public TrackStatisticDto(Map<TrackCourse.Type, Map<TrackJudge.PNP, CourseStatisticDto>> trackJudge) {
        trackStatistic(trackJudge);
    }

    public void trackStatistic(Map<TrackCourse.Type, Map<TrackJudge.PNP, CourseStatisticDto>> trackJudge) {
        Long totalMinSumAndRuleCredit = 0L;
        Long totalCourseCredit = 0L;
        Long totalRuleCredit = 0L;

        for(TrackCourse.Type type : trackJudge.keySet()){
            Map<TrackJudge.PNP, CourseStatisticDto> courseJudge = trackJudge.get(type);

            for(TrackJudge.PNP pnp : courseJudge.keySet()){
                CourseStatisticDto courseStatistic = courseJudge.get(pnp);

                if(pnp.equals(TrackJudge.PNP.PASS)) {
                    totalMinSumAndRuleCredit += courseStatistic.getMinSumAndRuleCredit();
                    totalCourseCredit += courseStatistic.getSumCredit();
                    totalRuleCredit += courseStatistic.getRuleCredit();
                }
            }
        }

        this.trackJudge = trackJudge;
        this.totalCourseCredit = totalCourseCredit;
        this.totalRuleCredit = totalRuleCredit;
        this.percent = totalCourseCredit != 0 ? Double.valueOf(totalMinSumAndRuleCredit) / Double.valueOf(totalRuleCredit) * 100.0 : 0.0;
        this.percentColor = PercentColor.percentToColor(this.percent).getHex();
    }

    public enum PercentColor{
        GREEN("#2dce89", "80~100%", 80L, 100L),
        BLUE("#11cdef", "50~79%", 50L, 79L),
        ORANGE("#fb6340", "30~49%", 30L, 49L),
        RED("#f5365c", "0~29%", 0L, 29L);

        private String hex;
        private String text;
        private Long min;
        private Long max;

        PercentColor(String hex, String text, Long min, Long max){
            this.hex = hex;
            this.text = text;
            this.min = min;
            this.max = max;
        }

        public String getText() {
            return text;
        }

        public String getHex() {
            return hex;
        }

        public static PercentColor percentToColor(Double  percent){
            return Arrays.stream(PercentColor.values())
                    .filter(percentColor -> percentColor.min < Long.valueOf(percent.longValue()))
                    .filter(percentColor -> percentColor.max > Long.valueOf(percent.longValue()))
                    .findAny()
                    .orElse(RED);
        }
    }
}
