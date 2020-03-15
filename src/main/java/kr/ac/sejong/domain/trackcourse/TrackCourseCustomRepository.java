package kr.ac.sejong.domain.trackcourse;

import java.util.List;

public interface TrackCourseCustomRepository {
    public List<TrackCourse> findByTrackId(Long trackId);
    public List<TrackCourse> findByUnivId(Long trackId);
}
