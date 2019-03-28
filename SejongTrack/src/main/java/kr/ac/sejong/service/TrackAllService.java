package kr.ac.sejong.service;

import kr.ac.sejong.domain.subjectVO;

import java.util.List;

public interface TrackAllService {
    public List<subjectVO> readTrack(Integer trackNo)throws Exception;
}
