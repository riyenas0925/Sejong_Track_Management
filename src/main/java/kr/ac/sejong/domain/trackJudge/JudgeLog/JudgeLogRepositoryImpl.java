package kr.ac.sejong.domain.trackJudge.JudgeLog;

import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;
import java.util.Optional;

@Log
public class JudgeLogRepositoryImpl extends QuerydslRepositorySupport implements JudgeLogCustomRepository {

    public JudgeLogRepositoryImpl() {
        super(JudgeLog.class);
    }

    @Override
    public List<JudgeLog> findAllByDesc() {
        QJudgeLog judgeLog = QJudgeLog.judgeLog;

        return from(judgeLog)
                .orderBy(judgeLog.id.desc())
                .fetch();
    }

    @Override
    public List<JudgeLog> findAllByMember(String userId) {
        QJudgeLog judgeLog = QJudgeLog.judgeLog;

        return from(judgeLog)
                .where(judgeLog.member.userId.eq(userId))
                .orderBy(judgeLog.id.desc())
                .fetch();
    }

    @Override
    public Optional<JudgeLog> findByMemberAndTrack(String userId, Long trackId) {
        QJudgeLog judgeLog = QJudgeLog.judgeLog;
        JudgeLog judgeLog1 = from(judgeLog)
                .where(judgeLog.member.userId.eq(userId).and(judgeLog.track.id.eq(trackId)))
                .fetchOne();        //처음 한 개만 가져옴
        return Optional.ofNullable(judgeLog1); //ofNullable해야됨
    }

    @Override
    public List<JudgeLog> findAllByTrack(Long trackId) {
        QJudgeLog judgeLog = QJudgeLog.judgeLog;

        return from(judgeLog)
                .where(judgeLog.track.id.eq(trackId))
                .orderBy(judgeLog.id.desc())
                .fetch();
    }
}
