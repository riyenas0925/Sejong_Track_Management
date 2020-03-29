package kr.ac.sejong.service;

import kr.ac.sejong.domain.course.Course;
import kr.ac.sejong.domain.rule.Rule;
import kr.ac.sejong.domain.trackJudge.TrackJudge;
import kr.ac.sejong.domain.trackcourse.TrackCourse;
import kr.ac.sejong.web.dto.trackjudge.TrackStatistic;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
}
