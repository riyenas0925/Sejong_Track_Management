package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long>{

}
