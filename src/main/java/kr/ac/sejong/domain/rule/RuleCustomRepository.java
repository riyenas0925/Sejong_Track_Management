package kr.ac.sejong.domain.rule;


import java.util.List;

public interface RuleCustomRepository {
    public List<Rule> findByTrackIdAndDegreeId(Long trackId, Long degreeId);
    public List<Rule> findByUnivIdDistinct(Long univId);
}
