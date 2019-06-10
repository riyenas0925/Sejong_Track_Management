package kr.ac.sejong.controller;

import kr.ac.sejong.domain.resultTrackVO;
import kr.ac.sejong.domain.ruleVO;
import kr.ac.sejong.domain.subjectVO;
import kr.ac.sejong.domain.trackSubjectVO;
import kr.ac.sejong.service.TrackRuleService;
import kr.ac.sejong.service.UploadResultService;

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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@SessionAttributes("file")
public class UploadResultController {

    private static final Logger logger = LoggerFactory.getLogger(UploadResultController.class);

    @Inject
    private UploadResultService service;

    @Inject
    private TrackRuleService trackRuleService;

    @GetMapping("uploadResult")
    public void uploadResult(Integer univNo, Integer trackNo, Model model, HttpSession httpSession)throws Exception{
        List<subjectVO> mySubList = service.readMySub((MultipartFile)httpSession.getAttribute("file"));
        List<trackSubjectVO> trackList = service.readSub(trackNo);

        HashMap<String, List<trackSubjectVO>> resultAllMap = service.resultListSub(mySubList, trackList);
        //ruleVO rule = trackRuleService.readRule(1, trackNo);

        model.addAttribute("resultAllMap", resultAllMap);
        //model.addAttribute("rule", rule);
    }

    @PostMapping("uploadResult")
    public void uploadResult(MultipartFile file, Model model, HttpSession httpSession)throws Exception{
        httpSession.setAttribute("file", file);
        httpSession.removeAttribute("resultList");
    }
}