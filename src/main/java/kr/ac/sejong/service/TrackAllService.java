package kr.ac.sejong.service;

import kr.ac.sejong.domain.rule.Rule;
import kr.ac.sejong.domain.rule.RuleRepository;
import kr.ac.sejong.domain.trackcourse.TrackCourse;
import kr.ac.sejong.domain.trackcourse.TrackCourseRepository;
import kr.ac.sejong.web.dto.course.CourseResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Log
@RequiredArgsConstructor
@Service
public class TrackAllService {
    private final TrackCourseRepository trackCourseRepository;
    private final RuleRepository trackRuleRepository;

    @Cacheable(value = "trackAll", key = "#univId")
    @Transactional
    public Map<String, Map<String, List<CourseResponseDto>>> trackAllStatistic(Long univId){
        List<TrackCourse> trackCourses = trackCourseRepository.findByUnivId(univId);
        List<Rule> univRuleTypes = trackRuleRepository.findByUnivIdDistinct(univId);

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
            for (Rule ruleType : univRuleTypes) {
                value.computeIfAbsent(ruleType.getCourseType().getText() , k -> Collections.emptyList());
            }
        });

        return trackAllStatistic;
    }
}
