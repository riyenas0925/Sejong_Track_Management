package kr.ac.sejong.service;

import kr.ac.sejong.dto.TrackAllViewDto;
import kr.ac.sejong.persistence_old.TrackAllDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class TrackAllServiceImpl implements TrackAllService {
    @Inject
    private TrackAllDAO dao;

    @Override
    public List<TrackAllViewDto> trackAll(Integer univNo)throws Exception{
        List<TrackAllViewDto> trackAllVOList = dao.trackAllList(univNo);

        return trackAllVOList;
    }
}