package kr.ac.sejong.service;

import kr.ac.sejong.domain.rule.Rule;
import kr.ac.sejong.domain.rule.RuleRepository;
import kr.ac.sejong.domain.track.Track;
import kr.ac.sejong.domain.track.TrackRepository;
import kr.ac.sejong.domain.trackcourse.TrackCourse;
import kr.ac.sejong.domain.univ.UnivRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Log
@Service
public class TrackRuleService {
    private final RuleRepository ruleRepository;
    private final TrackRepository trackRepository;

    @Transactional
    public Map<TrackCourse.Type, Rule> findByTrackIdAndDegreeId (Long trackId, Long degreeId) {
        return ruleFindByTrackIdAndDegreeId(trackId, degreeId);
    }

    @Transactional
    public Map<Track ,Map<TrackCourse.Type, Rule>> findByUnivIdAndDegreeId (Long univId, Long degreeId) {
        Map<Track, Map<TrackCourse.Type, Rule>> trackrules = new HashMap<>();

        List<Track> tracks = trackRepository.findByUnivId(univId);

        for(Track track : tracks) {
            Map<TrackCourse.Type, Rule> trackRule = ruleFindByTrackIdAndDegreeId(track.getId(), degreeId);
            trackrules.put(track ,trackRule);
        }

        return trackrules;
    }

    public Map<TrackCourse.Type, Rule> ruleFindByTrackIdAndDegreeId(Long trackId, Long degreeId) {
        List<Rule> rules = ruleRepository.findByTrackIdAndDegreeId(trackId, degreeId);

        Map<TrackCourse.Type, Rule> trackRule = new HashMap<>();

        for(Rule rule : rules) {
            trackRule.put(rule.getCourseType(), rule);
        }

        return trackRule;
    }

    @Transactional
    public List<Rule> findByUnivIdDistinct(Long univId) {
        return ruleRepository.findByUnivIdDistinct(univId);
    }
}
