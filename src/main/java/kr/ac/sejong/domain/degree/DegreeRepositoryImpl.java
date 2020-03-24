package kr.ac.sejong.domain.degree;

import kr.ac.sejong.domain.rule.QRule;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class DegreeRepositoryImpl extends QuerydslRepositorySupport implements DegreeCustomRepository {

    public DegreeRepositoryImpl() {
        super(Degree.class);
    }


    @Override
    public List<Degree> findByTrackId(Long trackId) {
        final QDegree degree = QDegree.degree;
        return from(degree)
                .where(degree.rules.any().track.id.eq(trackId))
                .fetch();
    }
}
