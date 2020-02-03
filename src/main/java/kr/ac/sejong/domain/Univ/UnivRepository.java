package kr.ac.sejong.domain.Univ;

import kr.ac.sejong.domain.Univ.Univ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnivRepository extends JpaRepository<Univ, Long> {

}
