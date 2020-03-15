package kr.ac.sejong.service;

import kr.ac.sejong.domain.trackcourse.TrackCourseRepository;
import kr.ac.sejong.web.dto.excel.ReportCardExcelDto;
import kr.ac.sejong.domain.trackJudge.TrackStatistic;
import kr.ac.sejong.web.dto.trackcourse.TrackCourseDto;
import kr.ac.sejong.web.dto.trackcourse.TrackCourseResponseDto;
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

    private final TrackCourseRepository trackSubjectRepository;

    @Transactional(readOnly = true)
    public List<TrackCourseResponseDto> findByTrackId(Long trackId) {
        return trackSubjectRepository.findByTrackId(trackId).stream()
                .map(TrackCourseResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<TrackCourseResponseDto> findByUnivId(Long univId) {
        return trackSubjectRepository.findByUnivId(univId).stream()
                .map(TrackCourseResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<TrackStatistic> trackJudge(List<ReportCardExcelDto> reportCardExcelSubjects,
                                                      List<TrackCourseDto>...standardSubjects) {

        List<TrackStatistic> trackStatistics = new ArrayList<>();

        for (List<TrackCourseDto> standardSubject : standardSubjects) {
            TrackStatistic trackStatistic = new TrackStatistic(reportCardExcelSubjects, standardSubject);
            trackStatistics.add(trackStatistic);
        }

        return trackStatistics;
    }
}
