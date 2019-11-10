package kr.ac.sejong.controller;

import kr.ac.sejong.domain_old.resultTrackVO;
import kr.ac.sejong.dto.StudentExcelDto;
import kr.ac.sejong.service.TrackJudgeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/uploadAjax/*")
public class TrackJudgeRestController {

    @Inject
    private TrackJudgeService trackJudgeService;

    @GetMapping("/allResult/{univNo}")
    public ResponseEntity<List<resultTrackVO>> allResult(@PathVariable Integer univNo, HttpSession httpSession) throws Exception{

        ResponseEntity<List<resultTrackVO>> entity = null;
        List<StudentExcelDto> mySubList = trackJudgeService.readMySubject((MultipartFile)httpSession.getAttribute("file"));

        try {
            if(httpSession.getAttribute("resultList") == null){
                httpSession.setAttribute("resultList", trackJudgeService.resultTrackList(univNo, mySubList));
            }

            entity = new ResponseEntity<>((List<resultTrackVO>)httpSession.getAttribute("resultList") , HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return entity;
    }
}