package kr.ac.sejong.domain.trackJudge;

import kr.ac.sejong.domain.course.Course;
import kr.ac.sejong.domain.rule.Rule;
import kr.ac.sejong.domain.trackcourse.TrackCourse;
import kr.ac.sejong.web.dto.course.CourseResponseDto;
import kr.ac.sejong.web.dto.trackjudge.CourseStatisticDto;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class TrackJudge {
    private List<Course> transcriptCourses;
    private List<TrackCourse> standardCourses;
    private Map<TrackCourse.Type, Rule> rule;

    @Builder
    public TrackJudge(List<Course> transcriptCourses,
                      List<TrackCourse> standardCourses,
                      Map<TrackCourse.Type, Rule> rule) {

        this.standardCourses = standardCourses;
        this.transcriptCourses = transcriptCourses;
        this.rule = rule;
    }

    public final Map<TrackCourse.Type, Map<TrackJudge.PNP, CourseStatisticDto>> statistic(){
        Map<TrackCourse.Type, Map<TrackJudge.PNP, CourseStatisticDto>> trackStatistic = this.standardCourses.stream()
                .collect(
                        Collectors.groupingBy(TrackCourse::getCourseType,
                                Collectors.groupingBy(trackSubjectDto -> {
                                            if(trackSubjectDto.getCourse().isContain(this.transcriptCourses)){
                                                return TrackJudge.PNP.PASS;
                                            } else {
                                                return TrackJudge.PNP.NON_PASS;
                                            }
                                        }
                                        ,Collectors.collectingAndThen(Collectors.toList(), list -> {
                                            return new CourseStatisticDto(
                                                    list.stream()
                                                            .map(TrackCourse::getCourse)
                                                            .map(CourseResponseDto::new)
                                                            .collect(Collectors.toList()),
                                                    list.stream().mapToLong(test -> {
                                                        return test.getCourse().getCredit();
                                                    }).sum(),
                                                    rule.get(list.get(1).getCourseType()).getCredit()
                                            );
                                        })
                                )
                        )
                );

        trackStatistic.forEach((key, value) -> {
            for (TrackJudge.PNP pnp : TrackJudge.PNP.values()) {
                value.computeIfAbsent(pnp, k -> new CourseStatisticDto(new ArrayList<>(Arrays.asList()), 0L, 0L));
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
    }}
