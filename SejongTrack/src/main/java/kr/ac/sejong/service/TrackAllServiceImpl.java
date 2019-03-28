package kr.ac.sejong.service;

import kr.ac.sejong.domain.subjectVO;
import kr.ac.sejong.domain.trackAllVO;
import kr.ac.sejong.domain.trackVO;
import kr.ac.sejong.domain.univVO;
import kr.ac.sejong.persistence.TrackAllDAO;
import kr.ac.sejong.persistence.TrackRuleDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class TrackAllServiceImpl implements TrackAllService {
    @Inject
    private TrackAllDAO dao;

    @Override
    public List<trackAllVO> basicTrack(Integer univNo)throws Exception{
        return dao.basicTrack(univNo);
    }

    @Override
    public List<trackAllVO> appliedTrack(Integer univNo) throws Exception{
        return dao.appliedTrack(univNo);
    }

    @Override
    public List<univVO> univName() throws Exception{
        return dao.univName();
    }

    @Override
    public List<trackVO> trackName(Integer univNo) throws Exception{
        return dao.trackName(univNo);
    }

}
