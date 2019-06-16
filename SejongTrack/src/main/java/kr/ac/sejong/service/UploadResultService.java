package kr.ac.sejong.service;

import kr.ac.sejong.domain_old.resultTrackVO;
import kr.ac.sejong.domain_old.ruleVO;
import kr.ac.sejong.domain_old.subjectVO;
import kr.ac.sejong.domain_old.trackSubjectVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;


public interface UploadResultService {
    public ruleVO readRule(Integer ruleNo) throws Exception;

    public List<trackSubjectVO> readSub(Integer subType) throws Exception;

    public List<trackSubjectVO> readTypeSub(Integer trackNo, Integer subType) throws Exception;

    public List<subjectVO> readMySub(MultipartFile file) throws Exception;

    public HashMap<String, List<trackSubjectVO>> resultListSub(List<subjectVO> myList, List<trackSubjectVO> standList) throws Exception;

    public List<resultTrackVO> resultTrackList(Integer univNo, List<subjectVO> myList)throws Exception;
}
