package kr.ac.sejong;

import kr.ac.sejong.domain.rule.Rule;
import kr.ac.sejong.domain.trackJudge.TrackJudge;
import kr.ac.sejong.domain.course.Course;
import kr.ac.sejong.domain.trackcourse.TrackCourse;
import kr.ac.sejong.service.TrackCourseService;
import kr.ac.sejong.service.TrackJudgeService;
import kr.ac.sejong.service.TrackRuleService;
import kr.ac.sejong.web.dto.excel.ExcelDto;
import kr.ac.sejong.web.dto.excel.ReportCardExcelDto;
import kr.ac.sejong.web.dto.trackjudge.TrackStatisticDto;
import lombok.extern.java.Log;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@ActiveProfiles(value = {"develop-h2"})
@SpringBootTest
@Log
public class TrackJudgeTest {

    @Autowired
    private TrackJudgeService trackJudgeService;
    @Autowired
    private TrackRuleService trackRuleService;
    @Autowired
    private TrackCourseService trackCourseService;


    List<Course> transcriptCourses;
    List<TrackCourse> standardCourses;

    @Before
    public void befor() throws IOException {
        String fileName = "testCardReport.xls";
        String filePath = "src/test/resources/testCardReport.xls";

        MultipartFile multipartFile = new MockMultipartFile(fileName, new FileInputStream(new File(filePath)));

        transcriptCourses = new ExcelDto(multipartFile).toReportCardExcelDtos().stream()
                .map(ReportCardExcelDto::toCourseEntity)
                .collect(Collectors.toList());

        standardCourses = trackCourseService.findByTrackId(1L);
    }

    @Test
    public void TrackJudegeTest1() {
        TrackJudge trackJudge = TrackJudge.builder()
                .standardCourses(standardCourses)
                .transcriptCourses(transcriptCourses)
                .rule(trackRuleService.findByTrackIdAndDegreeId(1L,1L))
                .build();

        TrackStatisticDto trackStatistic = new TrackStatisticDto(trackJudge.statistic());

        log.info(trackJudge.statistic().toString());
        log.info(trackStatistic.toString());
    }

    @Test
    public void 트랙_하나만_판단() {
        Map<TrackCourse.Type, Rule> trackRule = trackRuleService.findByTrackIdAndDegreeId(1L, 1L);

        TrackJudge trackJudge = TrackJudge.builder()
                .standardCourses(standardCourses)
                .transcriptCourses(transcriptCourses)
                .rule(trackRule)
                .build();

        TrackStatisticDto trackStatistic = new TrackStatisticDto(trackJudge.statistic());

        log.info(trackStatistic.toString());
    }

    /*
    @Test
    public void 트랙_전부_판단() {
        Map<TrackCourse.Type, Rule> trackRule = trackRuleService.findByTrackIdAndDegreeId(1L, 1L);
        Map<Track, List<TrackCourse>> test = trackCourseService.findByUnivId(1L);

        log.info(trackRule.toString());
        log.info(trackJudgeService.trackJudge(trackRule, transcriptCourses, test).toString());
    }

    @Test
    public void 과목_분류_메서드_테스트() {
        Map<TrackCourse.Type, Rule> trackRule = trackRuleService.findByTrackIdAndDegreeId(1L, 1L);

        List<TrackCourse> kkk = standardCourses.get(1);

        Map<TrackCourse.Type, Map<TrackJudge.PNP, CourseStatisticDto>> classifyAndJudgeSubjects = kkk.stream()
                .collect(
                        Collectors.groupingBy(TrackCourse::getCourseType,
                                Collectors.groupingBy(trackCourse -> {
                                            if (trackCourse.getCourse().isContain(transcriptCourses)) {
                                                return TrackJudge.PNP.PASS;
                                            } else {
                                                return TrackJudge.PNP.NON_PASS;
                                            }
                                        },
                                        Collectors.collectingAndThen(Collectors.toList(), list -> {
                                            return new CourseStatisticDto(
                                                    list.stream()
                                                            .map(TrackCourse::getCourse)
                                                            .map(CourseResponseDto::new)
                                                            .collect(Collectors.toList()),
                                                    list.stream().mapToLong(test -> {
                                                        return test.getCourse().getCredit();
                                                    }).sum(),
                                                    trackRule.get(list.get(1).getCourseType()).getCredit()
                                            );
                                        })
                                )
                        )
        );

        log.info(classifyAndJudgeSubjects.toString());

        classifyAndJudgeSubjects.forEach((key1, value1) -> {
                    value1.computeIfAbsent(TrackJudge.PNP.PASS, k -> new CourseStatisticDto());
                    value1.computeIfAbsent(TrackJudge.PNP.NON_PASS, k -> new CourseStatisticDto());
                }
        );

        log.info(classifyAndJudgeSubjects.toString());
    }
     */
}
