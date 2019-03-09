package kr.ac.sejong.controller;

import kr.ac.sejong.domain.subjectVO;
import kr.ac.sejong.domain.trackSubjectVO;
import kr.ac.sejong.service.UploadResultService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;

import java.util.HashMap;
import java.util.List;

@Controller
public class UploadResultController {

    private static final Logger logger = LoggerFactory.getLogger(UploadResultController.class);

    MultipartFile file;

    @Inject
    private UploadResultService service;

    @GetMapping("uploadResult")
    public void uploadResult(Integer trackNo, Integer univNo, Model model)throws Exception{

        logger.info(service.readMySub(file).toString());

        List<subjectVO> mySubList = service.readMySub(file);
        List<trackSubjectVO> tracklist = service.readSub(trackNo);

        HashMap<String, List<trackSubjectVO>> resultAllMap = service.resultListSub(mySubList, tracklist);

        logger.info(resultAllMap.toString());

        model.addAttribute("resultAllMap", resultAllMap);
        model.addAttribute("rule", service.readRule(trackNo));
    }

    @PostMapping("uploadResult")
    public void uploadResult(MultipartFile file, Model model)throws Exception{
        this.file = file;
    }
}