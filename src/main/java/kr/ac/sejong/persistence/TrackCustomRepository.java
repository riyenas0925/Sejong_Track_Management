package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.Track;

import java.util.List;

public interface TrackCustomRepository {
    public List<Track> findByUnivId(Long univId);
}
