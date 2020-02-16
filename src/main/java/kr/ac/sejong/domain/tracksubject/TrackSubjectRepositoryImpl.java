package kr.ac.sejong.domain.tracksubject;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class TrackSubjectRepositoryImpl extends QuerydslRepositorySupport implements TrackSubjectCustomRepository {

    public TrackSubjectRepositoryImpl() {
        super(TrackSubject.class);
    }

    @Override
    public List<TrackSubject> findByTrackId(Long trackId) {
        final QTrackSubject trackSubject = QTrackSubject.trackSubject;
        return from(trackSubject)
                .where(trackSubject.track.trackId.eq(trackId))
                .fetch();
    }

    @Override
    public List<TrackSubject> findByUnivId(Long univId) {
        final QTrackSubject trackSubject = QTrackSubject.trackSubject;
        return from(trackSubject)
                .where(trackSubject.track.univ.univId.eq(univId))
                .fetch();
    }
}
