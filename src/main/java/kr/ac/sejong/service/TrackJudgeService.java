package kr.ac.sejong.service;

import kr.ac.sejong.dto.StudentExcelDto;
import kr.ac.sejong.dto.TrackSubjectJoinDto;
import kr.ac.sejong.dto.TrackJudgeAllViewDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;


public interface TrackJudgeService {
    public List<StudentExcelDto> readMySubject(MultipartFile excelFile) throws Exception;

    public HashMap<String, List<TrackSubjectJoinDto>> resultListSub(List<StudentExcelDto> studentExcel,
                                                                    List<TrackSubjectJoinDto> standList) throws Exception;

    public List<TrackSubjectJoinDto> readSub(Long trackId) throws Exception;

    public List<TrackJudgeAllViewDto> trackJudgeList(Long univId, List<StudentExcelDto> studentExcel)throws Exception;
    
    public TrackJudgeAllViewDto trackJudgeOne(Long univId, Long trackId, Long degreeId, List<StudentExcelDto> studentExcel)throws Exception;
}
