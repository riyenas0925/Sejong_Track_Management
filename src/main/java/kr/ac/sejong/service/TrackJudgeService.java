package kr.ac.sejong.service;

import kr.ac.sejong.web.dto.excel.ReportCardExcelDto;
import kr.ac.sejong.web.dto.TrackSubjectJoinDto;
import kr.ac.sejong.web.dto.TrackJudgeAllViewDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;


public interface TrackJudgeService {
    public HashMap<String, List<TrackSubjectJoinDto>> resultListSub(List<ReportCardExcelDto> studentExcel,
                                                                    List<TrackSubjectJoinDto> standList) throws Exception;

    public List<TrackSubjectJoinDto> readSub(Long trackId) throws Exception;

    public List<TrackJudgeAllViewDto> trackJudgeList(Long univId, List<ReportCardExcelDto> studentExcel)throws Exception;
    
    public TrackJudgeAllViewDto trackJudgeOne(Long univId, Long trackId, Long degreeId, List<ReportCardExcelDto> studentExcel)throws Exception;
}
