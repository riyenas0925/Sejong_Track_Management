package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.testVO;
import kr.ac.sejong.domain.trackSubjectVO;

import java.util.List;


public interface UploadResultDAO {
    public testVO readRule(String trackName)throws Exception;

    public List<trackSubjectVO> readSub(String trackName)throws Exception;


}
