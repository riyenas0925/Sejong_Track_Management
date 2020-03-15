package kr.ac.sejong;

import kr.ac.sejong.domain.trackcourse.TrackCourseRepository;
import kr.ac.sejong.web.dto.trackcourse.TrackCourseResponseDto;
import lombok.extern.java.Log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@ActiveProfiles(value = {"develop-h2"})
@SpringBootTest
@Log
public class TrackCourseTest {

    @Autowired
    private TrackCourseRepository trackSubjectRepository;

    @Test
    public void 기준과목_전체검색(){
        List<TrackCourseResponseDto> subjects = trackSubjectRepository.findAll().stream()
                .map(TrackCourseResponseDto::new)
                .collect(Collectors.toList());

        log.info(subjects.toString());
    }

    @Test
    public void 기준과목_TrackId로_검색() {
        List<TrackCourseResponseDto> subjects = trackSubjectRepository.findByTrackId(1L).stream()
                .map(TrackCourseResponseDto::new)
                .collect(Collectors.toList());

        log.info(subjects.toString());
    }

    @Test
    public void 기준과목_UnivId로_전체_검색() {
        List<TrackCourseResponseDto> subjects = trackSubjectRepository.findByUnivId(1L).stream()
                .map(TrackCourseResponseDto::new)
                .collect(Collectors.toList());

        log.info(subjects.toString());
    }
}