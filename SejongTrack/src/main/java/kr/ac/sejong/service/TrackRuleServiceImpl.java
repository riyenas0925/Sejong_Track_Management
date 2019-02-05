package kr.ac.sejong.service;

import kr.ac.sejong.domain.ruleVO;
import kr.ac.sejong.persistence.TrackRuleDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class TrackRuleServiceImpl implements TrackRuleService {

    @Inject
    private TrackRuleDAO dao;

    @Override
    public void regist(ruleVO rule) throws Exception{
        dao.create(rule);
    }

    @Override
    public ruleVO read(Integer ruleNo) throws Exception{
        return dao.read(ruleNo);
    }

    @Override
    public void update(ruleVO rule) throws Exception{
        dao.update(rule);
    }

    @Override
    public void remove(Integer ruleNo) throws Exception{
        dao.delete(ruleNo);
    }

    @Override
    public List<ruleVO> listAll() throws Exception{
        return dao.listAll();
    }
}
