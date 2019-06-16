package kr.ac.sejong.persistence_old;

import kr.ac.sejong.domain_old.resultTrackVO;
import kr.ac.sejong.domain_old.ruleVO;
import kr.ac.sejong.domain_old.trackSubjectVO;

import java.util.List;


public interface UploadResultDAO {
    public ruleVO readRule(Integer ruleNo)throws Exception;

    public List<trackSubjectVO> readSub(Integer trackNo)throws Exception;

    public List<trackSubjectVO> readTypeSub(Integer trackNo, Integer subType)throws Exception;

    public List<resultTrackVO> trackList(Integer univNo)throws Exception;
}
