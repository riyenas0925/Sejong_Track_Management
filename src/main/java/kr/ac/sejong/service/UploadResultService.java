package kr.ac.sejong.service;

import kr.ac.sejong.domain_old.resultTrackVO;
import kr.ac.sejong.domain_old.ruleVO;
import kr.ac.sejong.domain_old.subjectVO;
import kr.ac.sejong.domain_old.trackSubjectVO;
import kr.ac.sejong.dto.StudentExcelDto;
import kr.ac.sejong.dto.TrackSubjectJoinDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;


public interface UploadResultService {
    public ruleVO readRule(Integer ruleNo) throws Exception;

    public List<TrackSubjectJoinDto> readSub(Integer subType) throws Exception;

    public List<trackSubjectVO> readTypeSub(Integer trackNo, Integer subType) throws Exception;

    public List<StudentExcelDto> readMySub(MultipartFile excelFile) throws Exception;

    public HashMap<String, List<TrackSubjectJoinDto>> resultListSub(List<StudentExcelDto> myList, List<TrackSubjectJoinDto> standList) throws Exception;

    public List<resultTrackVO> resultTrackList(Integer univNo, List<StudentExcelDto> myList)throws Exception;
}
