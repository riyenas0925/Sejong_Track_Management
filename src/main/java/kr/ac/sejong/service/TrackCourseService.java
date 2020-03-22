package kr.ac.sejong.service;

import kr.ac.sejong.domain.track.Track;
import kr.ac.sejong.domain.trackcourse.TrackCourse;
import kr.ac.sejong.domain.trackcourse.TrackCourseRepository;
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
public class TrackCourseService {

    private final TrackCourseRepository trackSubjectRepository;

    @Transactional(readOnly = true)
    public List<TrackCourse> findByTrackId(Long trackId) {
        return trackSubjectRepository.findByTrackId(trackId);
    }

    @Transactional(readOnly = true)
    public Map<Track, List<TrackCourse>> findByUnivId(Long univId) {
        return trackSubjectRepository.findByUnivId(univId).stream()
                .collect(Collectors.groupingBy(TrackCourse::getTrack));
    }
}
