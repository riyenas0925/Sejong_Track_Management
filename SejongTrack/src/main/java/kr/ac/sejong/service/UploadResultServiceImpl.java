package kr.ac.sejong.service;

import kr.ac.sejong.domain.testVO;
import kr.ac.sejong.domain.trackSubjectVO;
import kr.ac.sejong.persistence.UploadResultDAO;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class UploadResultServiceImpl implements UploadResultService{

    @Inject
    private UploadResultDAO dao;

    @Override
    public testVO readRule(Integer ruleNo) throws Exception{
        return dao.readRule(ruleNo);
    }

    @Override
    public List<trackSubjectVO> readSub(Integer subType) throws Exception{
        return dao.readSub(subType);
    }

    @Override
    public List<trackSubjectVO> readTypeSub(Integer trackNo, Integer subType)throws Exception{
        return dao.readTypeSub(trackNo, subType);
    }

}
