package kr.ac.sejong.service;

import kr.ac.sejong.domain.courseSchedule.CourseScheduleRepository;
import kr.ac.sejong.domain.degree.DegreeRepository;
import kr.ac.sejong.domain.rule.Rule;
import kr.ac.sejong.domain.rule.RuleRepository;
import kr.ac.sejong.domain.track.Track;
import kr.ac.sejong.domain.track.TrackRepository;
import kr.ac.sejong.domain.univ.UnivRepository;
import kr.ac.sejong.web.dto.courseschedule.CourseScheduleSelectResponseDto;
import kr.ac.sejong.web.dto.degree.DegreeResponseDto;
import kr.ac.sejong.web.dto.track.TrackResponseDto;
import kr.ac.sejong.web.dto.univ.UnivResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Log
@RequiredArgsConstructor
@Service
public class SelectBoxService {
    private final UnivRepository univRepository;
    private final TrackRepository trackRepository;
    private final RuleRepository ruleRepository;
    private final CourseScheduleRepository courseScheduleRepository;

    @Transactional(readOnly = true)
    public List<CourseScheduleSelectResponseDto> courseSchedule() {
        return courseScheduleRepository.findAll().stream()
                .map(CourseScheduleSelectResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<UnivResponseDto> univ() {
        return univRepository.findAll().stream()
                .map(UnivResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<TrackResponseDto> track(Long id) {
        return trackRepository.findByUnivId(id).stream()
                .map(TrackResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<DegreeResponseDto> degree(Long id) {

        List<Rule> rules = ruleRepository.findByTrackId(id);

        return rules.stream()
                .map(Rule::getDegree)
                .distinct()
                .map(DegreeResponseDto::new)
                .collect(Collectors.toList());
    }
}
