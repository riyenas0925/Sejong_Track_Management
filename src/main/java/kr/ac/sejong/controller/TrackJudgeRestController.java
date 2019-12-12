package kr.ac.sejong.controller;

import kr.ac.sejong.dto.StudentExcelDto;
import kr.ac.sejong.dto.TrackSubjectJoinDto;
import kr.ac.sejong.dto.TrackJudgeAllViewDto;
import kr.ac.sejong.service.TrackJudgeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/trackudge/*")
public class TrackJudgeRestController {

    private static final Logger logger = LoggerFactory.getLogger(TrackJudgeRestController.class);
    
    @Inject
    private TrackJudgeService trackJudgeService;

    @GetMapping("/all/{univId}")
    public ResponseEntity<List<TrackJudgeAllViewDto>> trackJudgeListRest(@PathVariable Long univId, HttpSession httpSession) throws Exception{

        ResponseEntity<List<TrackJudgeAllViewDto>> entity = null;
                
        List<StudentExcelDto> mySubList = (List<StudentExcelDto>) httpSession.getAttribute("studentExcel");
                
        try {
            if(httpSession.getAttribute("resultList") == null){
                logger.info("첫번째 조회");
                httpSession.setAttribute("resultList", trackJudgeService.trackJudgeList(univId, mySubList));
            }
            
            logger.info("일반 조회");
            entity = new ResponseEntity<>((List<TrackJudgeAllViewDto>)httpSession.getAttribute("resultList") , HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return entity;
    }
}