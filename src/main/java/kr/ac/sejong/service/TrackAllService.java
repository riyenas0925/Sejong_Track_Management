package kr.ac.sejong.service;

import kr.ac.sejong.dto.TrackAllViewDto;

import java.util.List;

public interface TrackAllService {
    public List<TrackAllViewDto> trackAll(Integer univNo)throws Exception;
}
