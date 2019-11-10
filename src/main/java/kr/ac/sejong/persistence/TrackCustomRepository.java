package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.Track;
import kr.ac.sejong.dto.TrackSubjectJoinDto;

import java.util.List;

public interface TrackCustomRepository {
    public List<Track> findByUnivId(Long univId);

    public List<TrackSubjectJoinDto> standardList(Long trackId);
}
