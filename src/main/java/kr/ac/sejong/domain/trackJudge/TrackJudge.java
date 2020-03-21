package kr.ac.sejong.domain.trackJudge;

import kr.ac.sejong.domain.course.Course;
import kr.ac.sejong.domain.trackcourse.TrackCourse;
import kr.ac.sejong.web.dto.course.CourseResponseDto;
import kr.ac.sejong.web.dto.trackjudge.CourseStatisticDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class TrackJudge {
    private Map<TrackCourse.Type, Map<TrackJudge.PNP, CourseStatisticDto>> trackStatistic;

    public TrackJudge(List<Course> transcriptTrack, List<TrackCourse> standardTracks){

        Map<TrackCourse.Type, Map<TrackJudge.PNP, CourseStatisticDto>> trackStatistic = standardTracks.stream()
                .collect(
                        Collectors.groupingBy(TrackCourse::getCourseType,
                                Collectors.groupingBy(trackSubjectDto -> {
                                            if(trackSubjectDto.getCourse().isContain(transcriptTrack)){
                                                return PNP.PASS;
                                            } else {
                                                return PNP.NON_PASS;
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
                                                     10L
                                            );
                                        })
                                )
                        )
                );

        trackStatistic.forEach((key1, value1) -> {
            for (TrackJudge.PNP pnp : TrackJudge.PNP.values()) {
                value1.computeIfAbsent(pnp, k -> new CourseStatisticDto());
            }
        });

        this.trackStatistic = trackStatistic;
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