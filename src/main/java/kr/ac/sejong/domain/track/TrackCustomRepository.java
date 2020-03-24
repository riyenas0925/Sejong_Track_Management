package kr.ac.sejong.domain.track;

import java.util.List;

public interface TrackCustomRepository {
    List<Track> findByUnivId(Long id);
}
