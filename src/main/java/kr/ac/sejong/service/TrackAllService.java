package kr.ac.sejong.service;

import kr.ac.sejong.web.dto.subject.SubjectResponseDto;
import kr.ac.sejong.web.dto.tracksubject.TrackSubjectDto;
import kr.ac.sejong.web.dto.tracksubject.TrackSubjectResponseDto;
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
        List<TrackSubjectDto> trackSubjects = trackJudgeService.findByUnivId(1L).stream()
                .map(TrackSubjectResponseDto::toTrackSubjectDto)
                .collect(Collectors.toList());

        Map<String, Map<String, List<SubjectResponseDto>>> trackAllStatistic = trackSubjects.stream()
                .collect(
                        Collectors.groupingBy(t -> {
                                    return t.getTrack().getTrackTitle();
                                },Collectors.groupingBy(l -> {
                                    return l.getSubjectType().getText();
                                },Collectors.collectingAndThen(Collectors.toList(), p -> {
                                    return p.stream().map(k -> {
                                        return k.getSubject();
                                    }).collect(Collectors.toList());
                                }))
                        )
                );

        return trackAllStatistic;
    }
}
