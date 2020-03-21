package kr.ac.sejong;

import kr.ac.sejong.domain.trackcourse.TrackCourse;
import kr.ac.sejong.domain.trackcourse.TrackCourseRepository;
import kr.ac.sejong.service.TrackJudgeService;
import kr.ac.sejong.web.dto.course.CourseResponseDto;
import kr.ac.sejong.web.dto.trackcourse.TrackCourseDto;
import kr.ac.sejong.web.dto.trackcourse.TrackCourseResponseDto;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@ActiveProfiles(value = {"develop-h2"})
@SpringBootTest
@Log
public class TrackAllTest {

    @Autowired
    private TrackCourseRepository trackCourseRepository;

    @Test
    public void 트랙_전체_보기() {
        List<TrackCourse> trackCourses = trackCourseRepository.findByUnivId(1L);

        Map<String, Map<String, List<CourseResponseDto>>> trackAllStatistic = trackCourses.stream()
                .collect(
                        Collectors.groupingBy(trackCourse -> {
                                    return trackCourse.getTrack().getTitle();
                                },Collectors.groupingBy(trackCourse -> {
                                    return trackCourse.getCourseType().getText();
                                },Collectors.collectingAndThen(Collectors.toList(), list -> {
                                    return list.stream().map(trackCourse -> {
                                        return new CourseResponseDto(trackCourse.getCourse());
                                    }).collect(Collectors.toList());
                                }))
                        )
                );

        log.info(trackAllStatistic.toString());
    }
}