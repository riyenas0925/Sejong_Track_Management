package kr.ac.sejong.persistence_jpa;

import kr.ac.sejong.domain_jpa.Track;

import java.util.List;

public interface TrackCustomRepository {
    public List<Track> findByUnivId(Long univId);
}
