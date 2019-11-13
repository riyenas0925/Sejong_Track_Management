package kr.ac.sejong.controller;

import kr.ac.sejong.dto.StudentExcelDto;
import kr.ac.sejong.dto.TrackSubjectJoinDto;
import kr.ac.sejong.dto.UnivTrackRuleDegreeJoinDto;
import kr.ac.sejong.service.TrackJudgeService;
import kr.ac.sejong.service.TrackRuleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

@Controller
public class TrackJudgeController {
    private static final Logger logger = LoggerFactory.getLogger(TrackJudgeController.class);

    @Inject
    private TrackJudgeService trackJudgeService;

    @Inject
    private TrackRuleService trackRuleService;

    @GetMapping("/uploadForm")
    public void uploadForm(Model model, HttpSession httpSession) throws Exception{
        httpSession.removeAttribute("studentExcel");
    }

    @GetMapping("/trackJudge")
    public void trackJudge(@RequestParam("univId") Integer univId, @RequestParam("trackId") Long trackId, @RequestParam("degreeId") Long degreeId, Model model,
                             HttpSession httpSession)throws Exception{

        List<StudentExcelDto> myList = (List<StudentExcelDto>) httpSession.getAttribute("studentExcel");
        List<TrackSubjectJoinDto> standardList = trackJudgeService.readSub(trackId);

        HashMap<String, List<TrackSubjectJoinDto>> resultAllMap = trackJudgeService.resultListSub(myList, standardList);
        
        UnivTrackRuleDegreeJoinDto rule = trackRuleService.findByRuleId(trackId, degreeId).get(0);
        
        model.addAttribute("resultAllMap", resultAllMap);
        model.addAttribute("rule", rule);
    }

    @PostMapping("/trackJudge")
    public void trackJudge(MultipartFile file, Model model, HttpSession httpSession)throws Exception{

        List<StudentExcelDto> studentExcel = trackJudgeService.readMySubject(file);
        
        logger.info("test =" + studentExcel.toString());
        
        httpSession.setAttribute("studentExcel", studentExcel);
        httpSession.removeAttribute("resultList");
    }
}