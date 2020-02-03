package kr.ac.sejong.persistence_old;

import kr.ac.sejong.dto.TrackAllViewDto;

import java.util.List;

public interface TrackAllDAO {
    public List<TrackAllViewDto> trackAllList(Integer univId) throws Exception;
}
