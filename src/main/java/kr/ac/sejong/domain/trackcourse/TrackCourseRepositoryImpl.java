package kr.ac.sejong.domain.trackcourse;

import kr.ac.sejong.domain.course.QCourse;
import kr.ac.sejong.domain.track.QTrack;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class TrackCourseRepositoryImpl extends QuerydslRepositorySupport implements TrackCourseCustomRepository {

    public TrackCourseRepositoryImpl() {
        super(TrackCourse.class);
    }

    @Override
    public List<TrackCourse> findByTrackId(Long trackId) {
        final QTrackCourse trackCourse = QTrackCourse.trackCourse;
        final QTrack track = QTrack.track;
        final QCourse course = QCourse.course;

        return from(trackCourse)
                .join(trackCourse.track, track).fetchJoin()
                .join(trackCourse.course, course).fetchJoin()
                .where(trackCourse.track.id.eq(trackId))
                .fetch();
    }

    @Override
    public List<TrackCourse> findByUnivId(Long univId) {
        final QTrackCourse trackCourse = QTrackCourse.trackCourse;
        final QTrack track = QTrack.track;
        final QCourse course = QCourse.course;

        return from(trackCourse)
                .join(trackCourse.track, track).fetchJoin()
                .join(trackCourse.course, course).fetchJoin()
                .where(trackCourse.track.univ.id.eq(univId))
                .fetch();
    }
}
