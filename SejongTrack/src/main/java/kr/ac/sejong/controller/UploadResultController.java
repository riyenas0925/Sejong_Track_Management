package kr.ac.sejong.controller;

import kr.ac.sejong.domain.subjectVO;
import kr.ac.sejong.domain.trackSubjectVO;
import kr.ac.sejong.service.UploadResultService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.inject.Inject;

import java.util.HashMap;
import java.util.List;

@Controller
public class UploadResultController {

    private static final Logger logger = LoggerFactory.getLogger(UploadResultController.class);

    @Inject
    private UploadResultService service;

    @GetMapping("uploadResult")
    public void uploadResult(Integer trackNo,Integer univNo, String savedName , Model model)throws Exception{

        List<subjectVO> mySubList = service.readMySub(savedName);
        List<trackSubjectVO> tracklist = service.readSub(trackNo);

        HashMap<String, List<trackSubjectVO>> resultAllMap = service.resultListSub(mySubList, tracklist);

        model.addAttribute("resultAllMap", resultAllMap);
        model.addAttribute("rule", service.readRule(trackNo));
    }
}