package kr.ac.sejong.service;

import kr.ac.sejong.domain.subjectVO;
import kr.ac.sejong.domain.trackAllVO;
import kr.ac.sejong.domain.trackVO;
import kr.ac.sejong.domain.univVO;
import kr.ac.sejong.persistence.TrackAllDAO;
import kr.ac.sejong.persistence.TrackRuleDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrackAllServiceImpl implements TrackAllService {
    @Inject
    private TrackAllDAO dao;

    @Override
    public List<trackAllVO> trackAll(Integer univNo)throws Exception{
        List<Integer> trackList = dao.trackAllList(univNo);
        List<trackAllVO> trackAllVOList = new ArrayList<>();

        for(int i = 0; i < trackList.size(); i++){
            trackAllVOList.add(dao.trackAll(trackList.get(i)));
        }

        return trackAllVOList;
    }
}
