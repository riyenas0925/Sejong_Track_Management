package kr.ac.sejong.controller;

import kr.ac.sejong.domain_old.trackSubjectVO;
import kr.ac.sejong.dto.StudentExcelDto;
import kr.ac.sejong.dto.TrackSubjectJoinDto;
import kr.ac.sejong.service.TrackRuleService;
import kr.ac.sejong.service.UploadResultService;

import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;

@Controller
@SessionAttributes("file")
@Log
public class UploadResultController {

    private static final Logger logger = LoggerFactory.getLogger(UploadResultController.class);

    @Inject
    private UploadResultService uploadResultService;

    @Inject
    private TrackRuleService trackRuleService;

    @GetMapping("uploadResult")
    public void uploadResult(Integer univNo, Integer trackNo, Model model, HttpSession httpSession)throws Exception{
        List<StudentExcelDto> mySubList = (List<StudentExcelDto>) httpSession.getAttribute("studentExcel");
        List<TrackSubjectJoinDto> trackList = uploadResultService.readSub(trackNo);

        HashMap<String, List<TrackSubjectJoinDto>> resultAllMap = uploadResultService.resultListSub(mySubList, trackList);
        //ruleVO rule = trackRuleService.readRule(1, trackNo);

        model.addAttribute("resultAllMap", resultAllMap);
        //model.addAttribute("rule", rule);
    }

    @PostMapping("uploadResult")
    public void uploadResult(MultipartFile file, Model model, HttpSession httpSession)throws Exception{

        List<StudentExcelDto> studentExcel = uploadResultService.readMySub(file);

        httpSession.setAttribute("studentExcel", studentExcel);
        httpSession.removeAttribute("resultList");
    }
}