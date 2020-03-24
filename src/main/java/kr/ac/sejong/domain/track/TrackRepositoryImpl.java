package kr.ac.sejong.domain.track;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class TrackRepositoryImpl extends QuerydslRepositorySupport implements TrackCustomRepository{

    public TrackRepositoryImpl() {
        super(Track.class);
    }


    @Override
    public List<Track> findByUnivId(Long id) {
        QTrack track = QTrack.track;
        return from(track)
                .where(track.univ.id.eq(id))
                .fetch();
    }
}
