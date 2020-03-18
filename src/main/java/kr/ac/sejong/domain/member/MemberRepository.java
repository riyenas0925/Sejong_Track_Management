package kr.ac.sejong.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {

    @Query("SELECT m from Member m where m.userId = :userId")
    Optional<Member> findByUserId(String userId);
}
