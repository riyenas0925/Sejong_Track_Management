package kr.ac.sejong.domain.degree;

import kr.ac.sejong.domain.rule.Rule;

import java.util.List;

public interface DegreeCustomRepository {
    public List<Degree> findByTrackId(Long trackId);
}
