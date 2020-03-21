package kr.ac.sejong.service;

import kr.ac.sejong.domain.course.Course;
import kr.ac.sejong.domain.trackcourse.TrackCourse;
import kr.ac.sejong.domain.trackcourse.TrackCourseRepository;
import kr.ac.sejong.web.dto.excel.ReportCardExcelDto;
import kr.ac.sejong.domain.trackJudge.TrackJudge;
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
    public List<TrackJudge> trackJudge(List<Course> transcriptTrack,
                                       List<TrackCourse>...standardTracks) {

        List<TrackJudge> trackJudges = new ArrayList<>();

        for (List<TrackCourse> standardTrack : standardTracks) {
            TrackJudge trackJudge = new TrackJudge(transcriptTrack, standardTrack);
            trackJudges.add(trackJudge);
        }

        return trackJudges;
    }
}
