package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.MemberRole;
import org.springframework.data.repository.CrudRepository;

public interface MemberRoleRepository extends CrudRepository<MemberRole,Long> {
}
