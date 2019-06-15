package kr.ac.sejong;

import kr.ac.sejong.domain.Track;
import kr.ac.sejong.domain.Univ;
import kr.ac.sejong.persistence.TrackRepository;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class TrackTest {

    @Inject
    private TrackRepository trackRepository;

    @Test
    public void createTrack(){

        Univ univ = new Univ();
        univ.setUnivId(1L);
        univ.setUnivTitle("생성 테스트");

        Track track = new Track();
        track.setTrackTitle("Test Track Title");

        track.setUniv(univ);

        trackRepository.save(track);
    }

    @Test
    public void updateTrack(){
        Univ univ = new Univ();
        univ.setUnivId(1L);
        univ.setUnivTitle("생성 테스트");

        Track track = new Track();
        track.setTrackId(3L);
        track.setTrackTitle("Update Track Title");
        track.setUniv(univ);

        trackRepository.save(track);
    }

    @Test
    public void trackList(){
        log.info(trackRepository.findByUnivId(1L).toString());
    }
}
