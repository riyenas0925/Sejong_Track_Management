package kr.ac.sejong.service;

import kr.ac.sejong.domain.tracksubject.TrackSubjectRepository;
import kr.ac.sejong.web.dto.excel.ReportCardExcelDto;
import kr.ac.sejong.domain.trackJudge.TrackStatistic;
import kr.ac.sejong.web.dto.tracksubject.TrackSubjectDto;
import kr.ac.sejong.web.dto.tracksubject.TrackSubjectResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Log
public class TrackJudgeService {

    private final TrackSubjectRepository trackSubjectRepository;

    @Transactional(readOnly = true)
    public List<TrackSubjectResponseDto> findByTrackId(Long trackId) {
        return trackSubjectRepository.findByTrackId(trackId).stream()
                .map(TrackSubjectResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<TrackSubjectResponseDto> findByUnivId(Long univId) {
        return trackSubjectRepository.findByUnivId(univId).stream()
                .map(TrackSubjectResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<TrackStatistic> trackJudge(List<ReportCardExcelDto> reportCardExcelSubjects,
                                                      List<TrackSubjectDto>...standardSubjects) {

        List<TrackStatistic> trackStatistics = new ArrayList<>();

        for (List<TrackSubjectDto> standardSubject : standardSubjects) {
            TrackStatistic trackStatistic = new TrackStatistic(reportCardExcelSubjects, standardSubject);
            trackStatistics.add(trackStatistic);
        }

        return trackStatistics;
    }
}
