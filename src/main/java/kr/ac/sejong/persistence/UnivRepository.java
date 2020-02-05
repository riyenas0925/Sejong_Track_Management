package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.Univ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnivRepository extends JpaRepository<Univ, Long> {

}
