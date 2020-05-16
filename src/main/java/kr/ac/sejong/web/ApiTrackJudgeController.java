package kr.ac.sejong.web;

import kr.ac.sejong.domain.course.Course;
import kr.ac.sejong.domain.rule.Rule;
import kr.ac.sejong.domain.track.Track;
import kr.ac.sejong.domain.trackcourse.TrackCourse;
import kr.ac.sejong.service.JudgeLogService;
import kr.ac.sejong.service.TrackCourseService;
import kr.ac.sejong.service.TrackJudgeService;
import kr.ac.sejong.service.TrackRuleService;
import kr.ac.sejong.web.dto.CustomUserDetails;
import kr.ac.sejong.web.dto.excel.ReportCardExcelDto;
import kr.ac.sejong.web.dto.trackjudge.JudgeLogRequestDto;
import kr.ac.sejong.web.dto.trackjudge.TrackStatistic;
import kr.ac.sejong.web.dto.trackjudge.TrackStatisticSummary;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Log
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/trackJudge/*")
public class ApiTrackJudgeController {

    private final TrackJudgeService trackJudgeService;
    private final TrackRuleService trackRuleService;
    private final TrackCourseService trackCourseService;
    private final JudgeLogService judgeLogService;

    @PostMapping("one")
    public TrackStatistic trackJudgeOne(@RequestParam("univId") Long univId,
                                        @RequestParam("trackId") Long trackId,
                                        @RequestParam("degreeId") Long degreeId,
                                        HttpSession httpSession) throws Exception {
        /** 판정 **/
        List<ReportCardExcelDto> transcriptExcel = (List<ReportCardExcelDto>) httpSession.getAttribute("transcript");

        Map<TrackCourse.Type, Rule> trackRule = trackRuleService.findByTrackIdAndDegreeId(trackId, degreeId);
        List<TrackCourse> standardCourses = trackCourseService.findByTrackId(trackId);
        List<Course> transcriptCourses = transcriptExcel.stream()
                .map(ReportCardExcelDto
                        ::toCourseEntity)
                .collect(Collectors.toList());

        TrackStatistic trackStatistic = trackJudgeService.trackJudgeOne(trackRule, transcriptCourses, standardCourses);

        return trackStatistic;
    }

    @PostMapping("all")
    public List<TrackStatisticSummary> trackJudgeAll(@RequestParam("univId") Long univId,
                                                     @RequestParam("degreeId") Long degreeId,
                                                     HttpSession httpSession) throws Exception {
        CustomUserDetails userModel = (CustomUserDetails) httpSession.getAttribute("userModel");

        /** 판정 **/
        List<ReportCardExcelDto> transcriptExcel = (List<ReportCardExcelDto>) httpSession.getAttribute("transcript");
        List<Course> transcriptCourses = transcriptExcel.stream()
                .map(ReportCardExcelDto::toCourseEntity)
                .collect(Collectors.toList());


        /* 트랙 규칙*/
        Map<Track, Map<TrackCourse.Type, Rule>> trackRule = trackRuleService.findByUnivIdAndDegreeId(univId, degreeId);

        /* 기준 트랙 과목 */
        Map<Track, List<TrackCourse>> standardCourses = trackCourseService.findByUnivId(univId);

        List<TrackStatisticSummary> trackStatistics = trackJudgeService.trackJudgeAll(trackRule, transcriptCourses, standardCourses);

        /** 판정 기록 --> 모든 트랙 대상**/
        List<JudgeLogRequestDto> judgeLogRequestDtos = null;

        trackStatistics.stream().forEach(trackStatisticSummary ->
        {
            JudgeLogRequestDto dto = new JudgeLogRequestDto(trackStatisticSummary, userModel.getUserId());
            judgeLogRequestDtos.add(dto);
        });//--> .map(JudgeLogRequestDto::new)쓰기엔 인자가 두개 허용안되는 것 같음.

        judgeLogService.updateOrInsert(judgeLogRequestDtos);

        return trackStatistics;
    }
}