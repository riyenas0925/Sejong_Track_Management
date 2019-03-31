package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.resultTrackVO;
import kr.ac.sejong.domain.ruleVO;
import kr.ac.sejong.domain.trackSubjectVO;

import java.util.List;


public interface UploadResultDAO {
    public ruleVO readRule(Integer ruleNo)throws Exception;

    public List<trackSubjectVO> readSub(Integer trackNo)throws Exception;

    public List<trackSubjectVO> readTypeSub(Integer trackNo, Integer subType)throws Exception;

    public List<resultTrackVO> trackList(Integer univNo)throws Exception;
}
