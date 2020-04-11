package kr.ac.sejong.domain.trackJudge.JudgeLog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JudgeLogRepository extends JpaRepository<JudgeLog, Long>, JudgeLogCustomRepository {

    public Long deleteByMember(String userId);

    public Long deleteByTrack(Long trackId);
}
