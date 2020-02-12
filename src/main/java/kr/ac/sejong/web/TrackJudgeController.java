package kr.ac.sejong.web;

import kr.ac.sejong.web.dto.*;
import kr.ac.sejong.service.TrackJudgeService;
import kr.ac.sejong.service.TrackRuleService;
import kr.ac.sejong.web.dto.courseschedule.CourseScheduleRequestDto;
import kr.ac.sejong.web.dto.excel.CourseScheduleExcelDto;
import kr.ac.sejong.web.dto.excel.ExcelDto;
import kr.ac.sejong.web.dto.excel.ReportCardExcelDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Log
@Controller
@RequiredArgsConstructor
public class TrackJudgeController {

    private final TrackJudgeService trackJudgeService;
    private final TrackRuleService trackRuleService;

    @GetMapping("/uploadForm")
    public void uploadForm(Model model, HttpSession httpSession) throws Exception{
        httpSession.removeAttribute("studentExcel");
    }

    @GetMapping("/trackJudge")
    public void trackJudge(@RequestParam("univId") Long univId, 
                           @RequestParam("trackId") Long trackId, 
                           @RequestParam("degreeId") Long degreeId, 
                           Model model, HttpSession httpSession)throws Exception{

        List<ReportCardExcelDto> studentSubList = (List<ReportCardExcelDto>) httpSession.getAttribute("studentExcel");

        List<TrackSubjectJoinDto> standardSubList = trackJudgeService.readSub(trackId);

        HashMap<String, List<TrackSubjectJoinDto>> resultAllMap = trackJudgeService.resultListSub(studentSubList, standardSubList);
        
        TrackJudgeAllViewDto resultTrack = trackJudgeService.trackJudgeOne(univId, trackId, degreeId, studentSubList);

        model.addAttribute("resultAllMap", resultAllMap);
        model.addAttribute("resultTrack", resultTrack);
    }

    /*Ref com*/

    @PostMapping("/trackJudge")
    public void trackJudge(MultipartFile file, HttpSession httpSession)throws Exception{
        ExcelDto reportCardExcel = ExcelDto.builder()
                .multipartFile(file)
                .build();

        List<ReportCardExcelDto> reportCardSubjects = reportCardExcel.toReportCardExcelDtos();

        log.info(reportCardSubjects.toString());
                
        httpSession.setAttribute("studentExcel", reportCardSubjects);
        httpSession.removeAttribute("resultList");
    }
}