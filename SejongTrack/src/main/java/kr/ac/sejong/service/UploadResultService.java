package kr.ac.sejong.service;

import kr.ac.sejong.domain.testVO;
import kr.ac.sejong.domain.trackSubjectVO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UploadResultService {
    public testVO readRule(String trackName)throws Exception;

    public List<trackSubjectVO> readSub(String trackName)throws Exception;
}
