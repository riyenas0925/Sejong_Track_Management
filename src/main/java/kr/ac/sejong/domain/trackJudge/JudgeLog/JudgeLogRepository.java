package kr.ac.sejong.domain.trackJudge.JudgeLog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JudgeLogRepository extends JpaRepository<JudgeLog, Long>, JudgeLogCustomRepository {

    public Long deleteByMember_UserId(String userId);

    public Long deleteByTrack_Id(Long trackId);
}
