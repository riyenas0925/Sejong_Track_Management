package kr.ac.sejong.service;

import kr.ac.sejong.domain.ruleVO;
import kr.ac.sejong.domain.trackSubjectVO;

import java.util.List;


public interface UploadResultService {
    public ruleVO readRule(Integer ruleNo)throws Exception;

    public List<trackSubjectVO> readSub(Integer subType)throws Exception;

    public List<trackSubjectVO> readTypeSub(Integer trackNo, Integer subType)throws Exception;

}
