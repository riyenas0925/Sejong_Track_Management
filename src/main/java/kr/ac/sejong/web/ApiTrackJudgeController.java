package kr.ac.sejong.web;

import kr.ac.sejong.domain.course.Course;
import kr.ac.sejong.domain.trackcourse.TrackCourse;
import kr.ac.sejong.domain.trackcourse.TrackCourseRepository;
import kr.ac.sejong.service.TrackJudgeService;
import kr.ac.sejong.web.dto.excel.ReportCardExcelDto;
import kr.ac.sejong.domain.trackJudge.TrackJudge;
import kr.ac.sejong.web.dto.trackcourse.TrackCourseResponseDto;
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
public class ApiTrackJudgeController {

    private final TrackCourseRepository trackCourseRepository;
    private final TrackJudgeService trackJudgeService;

    @GetMapping("track/{trackId}")
    public List<TrackJudge> trackJudgeOne(@PathVariable("trackId") Long trackId,
                                          HttpSession httpSession)throws Exception{

        List<ReportCardExcelDto> reportCardSubjects = (List<ReportCardExcelDto>) httpSession.getAttribute("reportCard");

        List<Course> transcriptTrack = reportCardSubjects.stream()
                .map(ReportCardExcelDto::toCourseEntity)
                .collect(Collectors.toList());

        List<TrackCourse> standardSubjects = trackCourseRepository.findByTrackId(trackId);


        return trackJudgeService.trackJudge(transcriptTrack, standardSubjects);
    }

    @GetMapping("univ/{univId}")
    public List<TrackJudge> trackJudgeAll(@PathVariable("univId") Long univId,
                                          HttpSession httpSession)throws Exception{

        return null;
    }

    @GetMapping("track/standard/{trackId}")
    public List<TrackCourseResponseDto> standardSubjectsfindByTrackId(@PathVariable("trackId") Long trackId){
        return trackJudgeService.findByTrackId(trackId);
    }

    @GetMapping("univ/standard/{univId}")
    public List<TrackCourseResponseDto> standardSubjectsfindByUnivId(@PathVariable("univId") Long univId){
        return trackJudgeService.findByUnivId(univId);
    }
}