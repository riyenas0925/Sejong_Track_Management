package kr.ac.sejong.domain.trackJudge;

import kr.ac.sejong.domain.course.Course;
import kr.ac.sejong.domain.trackcourse.TrackCourse;
import kr.ac.sejong.web.dto.excel.ReportCardExcelDto;
import kr.ac.sejong.web.dto.course.CourseRequestDto;
import kr.ac.sejong.web.dto.trackjudge.CourseStatisticDto;
import kr.ac.sejong.web.dto.trackcourse.TrackCourseDto;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.java.Log;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@ToString
@Log
public class TrackStatistic {
    private Map<TrackCourse.Type, Map<TrackStatistic.PNP, CourseStatisticDto>> trackStatistic;

    public TrackStatistic(List<ReportCardExcelDto> reportCardExcelSubjects, List<TrackCourseDto> standardSubjects){

        List<Course> reportCardCourses = reportCardExcelSubjects.stream()
                .map(ReportCardExcelDto::toSubjectDto)
                .map(CourseRequestDto::toEntity)
                .collect(Collectors.toList());


        Map<TrackCourse.Type, Map<TrackStatistic.PNP, CourseStatisticDto>> classifySubjects = standardSubjects.stream()
                .collect(
                        Collectors.groupingBy(TrackCourseDto::getCourseType,
                                Collectors.groupingBy(trackSubjectDto -> {
                                            if(trackSubjectDto.getCourse().toSubjectDto().isContain(reportCardCourses)){
                                                return PNP.PASS;
                                            } else {
                                                return PNP.NON_PASS;
                                            }
                                        }
                                        ,Collectors.collectingAndThen(Collectors.toList(), list -> {
                                            return new CourseStatisticDto(
                                                    list.stream().collect(Collectors.toList()),
                                                    list.stream().collect(Collectors.summingLong(test -> {
                                                        return test.getCourse().getCredit();
                                                    }))
                                            );
                                        })
                                )
                        )
                );

        this.trackStatistic = classifySubjects;
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