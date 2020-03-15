package kr.ac.sejong.service;

import kr.ac.sejong.web.dto.course.CourseResponseDto;
import kr.ac.sejong.web.dto.trackcourse.TrackCourseDto;
import kr.ac.sejong.web.dto.trackcourse.TrackCourseResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Log
public class TrackAllService {
    private final TrackJudgeService trackJudgeService;

    @Transactional
    public Map trackAllStatistic(Long univId){
        List<TrackCourseDto> trackSubjects = trackJudgeService.findByUnivId(1L).stream()
                .map(TrackCourseResponseDto::toTrackSubjectDto)
                .collect(Collectors.toList());

        Map<String, Map<String, List<CourseResponseDto>>> trackAllStatistic = trackSubjects.stream()
                .collect(
                        Collectors.groupingBy(t -> {
                                    return t.getTrack().getTitle();
                                },Collectors.groupingBy(l -> {
                                    return l.getCourseType().getText();
                                },Collectors.collectingAndThen(Collectors.toList(), p -> {
                                    return p.stream().map(k -> {
                                        return k.getCourse();
                                    }).collect(Collectors.toList());
                                }))
                        )
                );

        return trackAllStatistic;
    }
}
