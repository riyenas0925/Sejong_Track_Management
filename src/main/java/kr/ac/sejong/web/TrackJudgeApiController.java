package kr.ac.sejong.web;

import kr.ac.sejong.service.TrackJudgeService;
import kr.ac.sejong.web.dto.excel.ReportCardExcelDto;
import kr.ac.sejong.domain.trackJudge.TrackStatistic;
import kr.ac.sejong.web.dto.tracksubject.TrackSubjectDto;
import kr.ac.sejong.web.dto.tracksubject.TrackSubjectResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Log
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/trackJudge/*")
public class TrackJudgeApiController {

    private final TrackJudgeService trackJudgeService;

    @GetMapping("track/{trackId}")
    public List<TrackStatistic> trackJudgeOne(@PathVariable("trackId") Long trackId,
                                                         HttpSession httpSession)throws Exception{

        List<ReportCardExcelDto> reportCardSubjects = (List<ReportCardExcelDto>) httpSession.getAttribute("reportCard");
        List<TrackSubjectDto> standardSubjects = trackJudgeService.findByTrackId(trackId).stream()
                .map(TrackSubjectResponseDto::toTrackSubjectDto)
                .collect(Collectors.toList());

        return trackJudgeService.trackJudge(reportCardSubjects, standardSubjects);
    }

    @GetMapping("univ/{univId}")
    public List<TrackStatistic> trackJudgeAll(@PathVariable("univId") Long univId,
                                              HttpSession httpSession)throws Exception{

        return null;
    }

    @GetMapping("track/standard/{trackId}")
    public List<TrackSubjectResponseDto> standardSubjectsfindByTrackId(@PathVariable("trackId") Long trackId){
        return trackJudgeService.findByTrackId(trackId);
    }

    @GetMapping("univ/standard/{univId}")
    public List<TrackSubjectResponseDto> standardSubjectsfindByUnivId(@PathVariable("univId") Long univId){
        return trackJudgeService.findByUnivId(univId);
    }
}