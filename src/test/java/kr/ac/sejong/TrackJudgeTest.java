package kr.ac.sejong;

import kr.ac.sejong.domain.course.Course;
import kr.ac.sejong.domain.track.Track;
import kr.ac.sejong.domain.trackJudge.TrackJudge;
import kr.ac.sejong.domain.trackcourse.TrackCourse;
import kr.ac.sejong.domain.trackcourse.TrackCourseRepository;
import kr.ac.sejong.service.TrackJudgeService;
import kr.ac.sejong.web.dto.course.CourseResponseDto;
import kr.ac.sejong.web.dto.trackjudge.CourseStatisticDto;
import kr.ac.sejong.web.dto.excel.ExcelDto;
import kr.ac.sejong.web.dto.excel.ReportCardExcelDto;
import kr.ac.sejong.web.dto.course.CourseRequestDto;
import kr.ac.sejong.web.dto.trackcourse.TrackCourseResponseDto;
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
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@ActiveProfiles(value = {"develop-h2"})
@SpringBootTest
@Log
public class TrackJudgeTest{

    @Autowired
    private TrackJudgeService trackJudgeService;

    @Autowired
    private TrackCourseRepository trackCourseRepository;

    List<Course> transcriptCourses;
    List<TrackCourse> standardSubjects;
    MultipartFile multipartFile;

    @Before
    public void befor() throws IOException {
        String fileName = "testCardReport.xls";
        String filePath = "src/test/resources/testCardReport.xls";

        multipartFile = new MockMultipartFile(fileName, new FileInputStream(new File(filePath)));

        transcriptCourses = new ExcelDto(multipartFile).toReportCardExcelDtos().stream()
                .map(ReportCardExcelDto::toCourseEntity)
                .collect(Collectors.toList());

        standardSubjects = trackCourseRepository.findByTrackId(1L);
    }

    @Test
    public void 트랙_하나만_판단() {
        List<TrackJudge> trackJudges = trackJudgeService.trackJudge(transcriptCourses, standardSubjects);
        log.info(trackJudges.toString());
    }

    @Test
    public void 트랙_전부_판단() {
        List<TrackCourse>[] test = new List[]{
                trackCourseRepository.findByTrackId(1L),
                trackCourseRepository.findByTrackId(2L)
        };

        log.info(trackJudgeService.trackJudge(transcriptCourses, test).toString());
    }

    @Test
    public void 과목_분류_메서드_테스트() {

        Map<TrackCourse.Type, Long> ruleCredit = new HashMap<>();
        ruleCredit.put(TrackCourse.Type.APPLIED, 18L);
        ruleCredit.put(TrackCourse.Type.BASIC, 9L);

        Map<TrackCourse.Type, Map<TrackJudge.PNP, CourseStatisticDto>> classifyAndJudgeSubjects = standardSubjects.stream()
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
                                                    ruleCredit.get(list.get(1).getCourseType())
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
}
