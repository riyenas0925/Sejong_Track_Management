package kr.ac.sejong.domain.tracksubject;

import java.util.List;

public interface TrackSubjectCustomRepository {
    public List<TrackSubject> findByTrackId(Long trackId);
    public List<TrackSubject> findByUnivId(Long trackId);
}
