package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.TrackSubject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackSubjectRepository extends  JpaRepository<TrackSubject, Long>{

}