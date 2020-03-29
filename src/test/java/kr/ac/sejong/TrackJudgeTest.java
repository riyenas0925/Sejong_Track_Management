package kr.ac.sejong;

import kr.ac.sejong.domain.rule.Rule;
import kr.ac.sejong.domain.course.Course;
import kr.ac.sejong.domain.track.Track;
import kr.ac.sejong.domain.trackcourse.TrackCourse;
import kr.ac.sejong.service.TrackCourseService;
import kr.ac.sejong.service.TrackJudgeService;
import kr.ac.sejong.service.TrackRuleService;
import kr.ac.sejong.web.dto.excel.ExcelDto;
import kr.ac.sejong.web.dto.excel.ReportCardExcelDto;
import kr.ac.sejong.web.dto.trackjudge.TrackStatistic;
import lombok.extern.java.Log;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.closeTo;

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

    @Before
    public void before() throws IOException {
        String fileName = "testCardReport.xls";
        String filePath = "src/test/resources/testCardReport.xls";

        MultipartFile multipartFile = new MockMultipartFile(fileName, new FileInputStream(new File(filePath)));

        transcriptCourses = new ExcelDto(multipartFile).toReportCardExcelDtos().stream()
                .map(ReportCardExcelDto::toCourseEntity)
                .collect(Collectors.toList());
    }

    @Test
    @Transactional
    public void 트랙_하나만_판단() {
        //Given
        Long trackId = 1L;
        Long degreeId = 1L;

        Map<TrackCourse.Type, Rule> trackRule = trackRuleService.findByTrackIdAndDegreeId(trackId, degreeId);
        List<TrackCourse> standardCourses = trackCourseService.findByTrackId(trackId);

        //When
        TrackStatistic trackStatistic = trackJudgeService.trackJudgeOne(trackRule, transcriptCourses, standardCourses);

        //That
        //testCardReport = HCI Track Percent 33.33333%
        Assert.assertThat(trackStatistic.getPercent(), closeTo(33.3, 0.04));
    }
}
