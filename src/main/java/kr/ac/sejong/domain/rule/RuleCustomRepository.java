package kr.ac.sejong.domain.rule;


import java.util.List;

public interface RuleCustomRepository {
    public List<Rule> findByTrackIdAndDegreeId(Long trackId, Long degreeId);
    public List<Rule> findByUnivIdDistinct(Long univId);
    public List<Rule> findByUnivId(Long univId);
    public List<Rule> findByTrackId(Long trackId);
}
