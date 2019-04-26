package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.trackAllVO;

import java.util.List;

public interface TrackAllDAO {
    public List<trackAllVO> trackAllList(Integer univNo) throws Exception;
}
