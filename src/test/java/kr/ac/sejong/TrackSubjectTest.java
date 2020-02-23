package kr.ac.sejong;

import kr.ac.sejong.domain.subject.Subject;
import kr.ac.sejong.domain.tracksubject.TrackSubject;

import kr.ac.sejong.domain.tracksubject.TrackSubjectRepository;
import kr.ac.sejong.web.dto.subject.SubjectRequestDto;
import kr.ac.sejong.web.dto.tracksubject.TrackSubjectResponseDto;
import lombok.extern.java.Log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class TrackSubjectTest {

    @Autowired
    private TrackSubjectRepository trackSubjectRepository;

    @Test
    public void 기준과목_전체검색(){
        List<TrackSubjectResponseDto> subjects = trackSubjectRepository.findAll().stream()
                .map(TrackSubjectResponseDto::new)
                .collect(Collectors.toList());

        log.info(subjects.toString());
    }

    @Test
    public void 기준과목_TrackId로_검색() {
        List<TrackSubjectResponseDto> subjects = trackSubjectRepository.findByTrackId(1L).stream()
                .map(TrackSubjectResponseDto::new)
                .collect(Collectors.toList());

        log.info(subjects.toString());
    }

    @Test
    public void 기준과목_UnivId로_전체_검색() {
        List<TrackSubjectResponseDto> subjects = trackSubjectRepository.findByUnivId(1L).stream()
                .map(TrackSubjectResponseDto::new)
                .collect(Collectors.toList());

        log.info(subjects.toString());
    }
}