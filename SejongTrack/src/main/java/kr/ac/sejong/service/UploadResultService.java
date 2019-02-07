package kr.ac.sejong.service;

import kr.ac.sejong.domain.testVO;
import kr.ac.sejong.domain.trackSubjectVO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UploadResultService {
    public testVO readRule(Integer ruleNo)throws Exception;

    public List<trackSubjectVO> readSub(Integer subType)throws Exception;

    public List<trackSubjectVO> readTypeSub(Integer trackNo, Integer subType)throws Exception;

}
