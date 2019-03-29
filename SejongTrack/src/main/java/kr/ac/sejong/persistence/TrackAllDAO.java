package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.trackAllVO;
import kr.ac.sejong.domain.trackVO;
import kr.ac.sejong.domain.univVO;

import java.util.List;

public interface TrackAllDAO {
    public List<trackAllVO> trackAll(Integer univNo) throws Exception;
}
