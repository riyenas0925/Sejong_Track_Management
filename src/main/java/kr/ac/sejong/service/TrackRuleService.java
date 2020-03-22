package kr.ac.sejong.service;

import kr.ac.sejong.domain.rule.Rule;
import kr.ac.sejong.domain.rule.RuleRepository;
import kr.ac.sejong.domain.trackcourse.TrackCourse;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Log
@Service
public class TrackRuleService {
    private final RuleRepository ruleRepository;

    @Transactional
    public Map<TrackCourse.Type, Rule> findByTrackIdAndDegreeId (Long TrackId, Long DegreeId) {
        List<Rule> ruleList = ruleRepository.findByTrackIdAndDegreeId(TrackId, DegreeId);

        Map<TrackCourse.Type, Rule> trackRule = new HashMap<>();

        for(Rule rule : ruleList) {
            trackRule.put(rule.getCourseType(), rule);
        }

        return trackRule;
    }
}
