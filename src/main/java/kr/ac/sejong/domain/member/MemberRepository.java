package kr.ac.sejong.domain.member;

import kr.ac.sejong.domain.member.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, String> {

}
