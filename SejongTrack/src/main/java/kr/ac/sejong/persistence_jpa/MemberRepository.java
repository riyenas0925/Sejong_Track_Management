package kr.ac.sejong.persistence_jpa;

import kr.ac.sejong.domain_jpa.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long>{

}
