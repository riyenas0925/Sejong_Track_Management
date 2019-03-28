package kr.ac.sejong.service;

import kr.ac.sejong.domain.subjectVO;
import kr.ac.sejong.domain.trackAllVO;
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
    public List<trackAllVO> readTrack(Integer univNo)throws Exception{
        return dao.readTrack(univNo);
    }

}
