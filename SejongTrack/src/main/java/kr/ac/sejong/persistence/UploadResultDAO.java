package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.testVO;
import kr.ac.sejong.domain.trackSubjectVO;

import java.util.List;


public interface UploadResultDAO {
    public testVO readRule(Integer ruleNo)throws Exception;

    public List<trackSubjectVO> readSub(Integer trackNo)throws Exception;

    public List<trackSubjectVO> readTypeSub(Integer trackNo, Integer subType)throws Exception;

}
