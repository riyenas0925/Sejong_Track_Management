package kr.ac.sejong.domain.trackJudge;

import kr.ac.sejong.domain.course.Course;
import kr.ac.sejong.domain.member.Member;
import kr.ac.sejong.domain.rule.Rule;
import kr.ac.sejong.domain.track.Track;
import kr.ac.sejong.domain.trackcourse.TrackCourse;
import kr.ac.sejong.web.dto.course.CourseResponseDto;
import kr.ac.sejong.web.dto.trackjudge.CourseStatistic;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.java.Log;

import java.util.*;
import java.util.stream.Collectors;

@Log
@Getter
public class TrackJudge {
    private Track track;
    private Member member;
    private Double percent;
    private Long totalCourseCredit;
    private Long totalRuleCredit;
    private String percentColor;

    private List<Course> transcriptCourses;
    private List<TrackCourse> standardCourses;
    private Map<TrackCourse.Type, Rule> rule;
    private Map<TrackCourse.Type, Map<TrackJudge.PNP, CourseStatistic>> trackClassify;

    @Builder
    public TrackJudge(List<Course> transcriptCourses,
                      List<TrackCourse> standardCourses,
                      Map<TrackCourse.Type, Rule> rule) {

        this.standardCourses = standardCourses;
        this.transcriptCourses = transcriptCourses;
        this.rule = rule;
        this.track =standardCourses.stream().findAny().get().getTrack();
        this.trackClassify = trackClassify();

        Long totalMinSumAndRuleCredit = 0L;
        Long totalCourseCredit = 0L;
        Long totalRuleCredit = 0L;

        for(TrackCourse.Type type : trackClassify().keySet()){
            Map<TrackJudge.PNP, CourseStatistic> courseJudge = trackClassify().get(type);

            for(TrackJudge.PNP pnp : courseJudge.keySet()){
                CourseStatistic courseStatistic = courseJudge.get(pnp);

                if(pnp.equals(TrackJudge.PNP.PASS)) {
                    totalMinSumAndRuleCredit += courseStatistic.getMinSumAndRuleCredit();
                    totalCourseCredit += courseStatistic.getSumCredit();
                    totalRuleCredit += courseStatistic.getRuleCredit();
                }
            }
        }

        Double percent = totalCourseCredit != 0 ? calcPercent(totalMinSumAndRuleCredit, totalRuleCredit) : 0.0;

        this.totalCourseCredit = totalCourseCredit;
        this.totalRuleCredit = totalRuleCredit;
        this.percent = percent;
        this.percentColor = PercentColorEnum.percentToColor(percent).getHex();
    }

    public  Double calcPercent(Long numerator, Long denominator) {
        return Double.valueOf(numerator) / Double.valueOf(denominator) * 100.0;
    }

    public Map<TrackCourse.Type, Map<TrackJudge.PNP, CourseStatistic>> trackClassify(){
        Map<TrackCourse.Type, Map<TrackJudge.PNP, CourseStatistic>> trackStatistic = this.standardCourses.stream()
                .collect(
                        Collectors.groupingBy(TrackCourse::getCourseType,
                                Collectors.groupingBy(trackCourse -> {
                                            if(trackCourse.getCourse().isContain(this.transcriptCourses)){
                                                return TrackJudge.PNP.PASS;
                                            } else {
                                                return TrackJudge.PNP.NON_PASS;
                                            }
                                        }
                                        ,Collectors.collectingAndThen(Collectors.toList(), list -> {
                                            List<CourseResponseDto> courses = list.stream()
                                                    .map(TrackCourse::getCourse)
                                                    .map(CourseResponseDto::new)
                                                    .collect(Collectors.toList());

                                            Long sumCreedit = list.stream().mapToLong(trackCourse -> {
                                                return trackCourse.getCourse().getCredit();
                                            }).sum();

                                            TrackCourse.Type CourseType = list.stream()
                                                    .findAny()
                                                    .get()
                                                    .getCourseType();

                                            Long ruleCredit = rule.get(CourseType).getCredit();

                                            return CourseStatistic.builder()
                                                    .Courses(courses)
                                                    .sumCredit(sumCreedit)
                                                    .ruleCredit(ruleCredit)
                                                    .build();
                                        })
                                )
                        )
                );

        trackStatistic.forEach((courseType, value) -> {
            for (TrackJudge.PNP pnp : TrackJudge.PNP.values()) {
                value.computeIfAbsent(pnp, k -> {
                    return new CourseStatistic(Collections.emptyList(), 0L, rule.get(courseType).getCredit());
                });
            }
        });

        return trackStatistic;
    }

    public enum PNP{
        PASS("pass"),
        NON_PASS("non pass");

        private String text;

        PNP(String text){
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}
