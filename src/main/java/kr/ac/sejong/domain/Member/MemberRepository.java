package kr.ac.sejong.domain.Member;

import kr.ac.sejong.domain.Member.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {

}
