package kr.ac.sejong.persistence;


import kr.ac.sejong.domain.subjectVO;

import java.util.List;

public interface TrackAllDAO {
    public List<subjectVO> readTrack(Integer trackNo) throws Exception;
}
