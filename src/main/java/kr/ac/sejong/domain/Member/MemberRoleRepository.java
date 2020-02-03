package kr.ac.sejong.domain.Member;

import kr.ac.sejong.domain.Member.MemberRole;
import org.springframework.data.repository.CrudRepository;

public interface MemberRoleRepository extends CrudRepository<MemberRole,Long> {
}
