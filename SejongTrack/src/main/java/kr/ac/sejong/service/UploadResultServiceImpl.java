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
    public testVO readRule(String trackName) throws Exception{
        return dao.readRule(trackName);
    }

    @Override
    public List<trackSubjectVO> readSub(String trackName) throws Exception{
        return dao.readSub(trackName);
    }
}
