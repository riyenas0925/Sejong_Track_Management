package kr.ac.sejong;

import kr.ac.sejong.service.TrackJudgeService;
import kr.ac.sejong.web.dto.trackcourse.TrackCourseDto;
import kr.ac.sejong.web.dto.trackcourse.TrackCourseResponseDto;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class TrackAllTest {

    @Autowired
    private TrackJudgeService trackJudgeService;

    @Test
    public void 트랙_전체_보기() {
        List<TrackCourseDto> trackSubjects = trackJudgeService.findByUnivId(1L).stream()
                .map(TrackCourseResponseDto::toTrackSubjectDto)
                .collect(Collectors.toList());

        Map test = trackSubjects.stream()
                .collect(
                        Collectors.groupingBy(t -> {
                                return t.getTrack().getTitle();
                            },Collectors.groupingBy(TrackCourseDto::getCourseType,
                                Collectors.collectingAndThen(Collectors.toList(), p -> {
                                    return p.stream().map(k -> {
                                        return k.getCourse();
                                    }).collect(Collectors.toList());
                                })
                            )
                        )
                );

        log.info(test.toString());
    }
}