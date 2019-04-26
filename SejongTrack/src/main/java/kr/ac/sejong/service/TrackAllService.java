package kr.ac.sejong.service;

import kr.ac.sejong.domain.trackAllVO;

import java.util.List;

public interface TrackAllService {
    public List<trackAllVO> trackAll(Integer univNo)throws Exception;
}
