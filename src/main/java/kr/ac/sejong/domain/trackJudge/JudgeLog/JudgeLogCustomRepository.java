package kr.ac.sejong.domain.trackJudge.JudgeLog;

import java.util.List;
import java.util.Optional;

public interface JudgeLogCustomRepository {
    public List<JudgeLog> findAllByDesc();

    public List<JudgeLog> findAllByMember(String userId);

    public List<JudgeLog> findAllByTrack(Long trackId);

    public Optional<JudgeLog> findByMemberAndTrack(String userId, Long trackId);

//    public Long saveWithTrackAndMember(String userId, Long trackid);
}
