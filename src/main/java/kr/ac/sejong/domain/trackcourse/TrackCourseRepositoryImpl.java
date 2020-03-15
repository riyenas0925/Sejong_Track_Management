package kr.ac.sejong.domain.trackcourse;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class TrackCourseRepositoryImpl extends QuerydslRepositorySupport implements TrackCourseCustomRepository {

    public TrackCourseRepositoryImpl() {
        super(TrackCourse.class);
    }

    @Override
    public List<TrackCourse> findByTrackId(Long trackId) {
        final QTrackCourse trackCourse = QTrackCourse.trackCourse;
        return from(trackCourse)
                .where(trackCourse.track.id.eq(trackId))
                .fetch();
    }

    @Override
    public List<TrackCourse> findByUnivId(Long univId) {
        final QTrackCourse trackCourse = QTrackCourse.trackCourse;
        return from(trackCourse)
                .where(trackCourse.track.univ.id.eq(univId))
                .fetch();
    }
}
