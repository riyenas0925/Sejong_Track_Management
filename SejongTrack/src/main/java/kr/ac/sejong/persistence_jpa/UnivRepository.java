package kr.ac.sejong.persistence_jpa;

import kr.ac.sejong.domain_jpa.Univ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnivRepository extends JpaRepository<Univ, Long> {

}
