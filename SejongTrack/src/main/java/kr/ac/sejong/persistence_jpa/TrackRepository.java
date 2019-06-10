package kr.ac.sejong.persistence_jpa;

import kr.ac.sejong.domain_jpa.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface TrackRepository extends JpaRepository<Track, Long>, TrackCustomRepository {

}
