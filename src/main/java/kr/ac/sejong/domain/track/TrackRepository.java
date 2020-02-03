package kr.ac.sejong.domain.track;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Long>, TrackCustomRepository {

}
