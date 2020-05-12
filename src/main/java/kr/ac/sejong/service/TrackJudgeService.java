package kr.ac.sejong.service;

import kr.ac.sejong.domain.course.Course;
import kr.ac.sejong.domain.rule.Rule;
import kr.ac.sejong.domain.track.Track;
import kr.ac.sejong.domain.trackJudge.TrackJudge;
import kr.ac.sejong.domain.trackcourse.TrackCourse;
import kr.ac.sejong.web.dto.excel.ReportCardExcelDto;
import kr.ac.sejong.web.dto.trackjudge.TrackStatistic;
import kr.ac.sejong.web.dto.trackjudge.TrackStatisticSummary;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import javax.transaction.TransactionScoped;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Log
public class TrackJudgeService {

    @Transactional
    public TrackStatistic trackJudgeOne(Map<TrackCourse.Type, Rule> trackRule,
                                        List<Course> transcriptCourses,
                                        List<TrackCourse> standardCourses) {

        TrackJudge trackJudge = TrackJudge.builder()
                .standardCourses(standardCourses)
                .transcriptCourses(transcriptCourses)
                .rule(trackRule)
                .build();

        return new TrackStatistic(trackJudge);
    }

    @Transactional
    public List<TrackStatisticSummary> trackJudgeAll(Map<Track, Map<TrackCourse.Type, Rule>> trackRule,
                                                     List<Course> transcriptCourses,
                                                     Map<Track, List<TrackCourse>> standardCourses){

        List<TrackStatisticSummary> trackStatistics = new ArrayList<>();

        standardCourses.forEach((key, value) -> {
            TrackJudge trackJudge = TrackJudge.builder()
                    .standardCourses(standardCourses.get(key))
                    .transcriptCourses(transcriptCourses)
                    .rule(trackRule.get(key))
                    .build();

            trackStatistics.add(new TrackStatisticSummary(trackJudge));
        });

        return trackStatistics;
    }
}
