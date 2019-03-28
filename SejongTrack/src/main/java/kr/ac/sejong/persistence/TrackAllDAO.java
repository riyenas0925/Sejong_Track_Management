package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.trackAllVO;
import kr.ac.sejong.domain.trackVO;
import kr.ac.sejong.domain.univVO;

import java.util.List;

public interface TrackAllDAO {
    public List<trackAllVO> basicTrack(Integer univNo) throws Exception;
    public List<trackAllVO> appliedTrack(Integer univNo) throws Exception;
    public List<univVO> univName() throws Exception;
    public List<trackVO> trackName(Integer univNo) throws Exception;
}
