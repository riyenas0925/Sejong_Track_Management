package kr.ac.sejong.service;

import kr.ac.sejong.domain.ruleVO;
import kr.ac.sejong.domain.subjectVO;
import kr.ac.sejong.domain.trackSubjectVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;


public interface UploadResultService {
    public ruleVO readRule(Integer ruleNo) throws Exception;

    public List<trackSubjectVO> readSub(Integer subType) throws Exception;

    public List<trackSubjectVO> readTypeSub(Integer trackNo, Integer subType) throws Exception;

    public List<subjectVO> readMySub(MultipartFile file) throws Exception;

    public HashMap<String, List<trackSubjectVO>> resultListSub(List<subjectVO> myList, List<trackSubjectVO> standList) throws Exception;
}
