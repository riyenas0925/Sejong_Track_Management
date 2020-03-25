package kr.ac.sejong.service;

import kr.ac.sejong.domain.course.Course;
import kr.ac.sejong.domain.rule.Rule;
import kr.ac.sejong.domain.trackJudge.TrackJudge;
import kr.ac.sejong.domain.trackcourse.TrackCourse;
import kr.ac.sejong.domain.trackcourse.TrackCourseRepository;
import kr.ac.sejong.web.dto.course.CourseResponseDto;
import kr.ac.sejong.web.dto.trackcourse.TrackCourseDto;
import kr.ac.sejong.web.dto.trackcourse.TrackCourseResponseDto;
import kr.ac.sejong.web.dto.trackjudge.CourseStatisticDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Log
public class TrackAllService {
    private final TrackCourseRepository trackCourseRepository;
    private final TrackRuleService trackRuleService;

    @Transactional
    public Map<String, Map<String, List<CourseResponseDto>>> trackAllStatistic(Long univId){
        List<TrackCourse> trackCourses = trackCourseRepository.findByUnivId(univId);
        List<Rule> UnivRuleTypes = trackRuleService.findByUnivIdDistinct(univId);

        Map<String, Map<String, List<CourseResponseDto>>> trackAllStatistic = trackCourses.stream()
                .collect(
                        Collectors.groupingBy(trackCourse -> {
                                    return trackCourse.getTrack().getTitle();
                                },Collectors.groupingBy(trackCourse -> {
                                    return trackCourse.getCourseType().getText();
                                },Collectors.collectingAndThen(Collectors.toList(), list -> {
                                    return list.stream().map(trackCourse -> {
                                        return new CourseResponseDto(trackCourse.getCourse());
                                    }).collect(Collectors.toList());
                                }))
                        )
                );

        trackAllStatistic.forEach((key, value) -> {
            for (Rule ruleType : UnivRuleTypes) {
                value.computeIfAbsent(ruleType.getCourseType().getText() , k -> Collections.emptyList());
            }
        });

        return trackAllStatistic;
    }
}
