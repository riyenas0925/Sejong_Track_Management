package kr.ac.sejong.web.dto.trackjudge;

import kr.ac.sejong.domain.member.Member;
import kr.ac.sejong.domain.track.Track;
import kr.ac.sejong.domain.trackJudge.JudgeLog.JudgeLog;
import kr.ac.sejong.domain.trackJudge.TrackJudge;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class JudgeLogResponseDto {

    private Double percent;
    private TrackJudge.PNP pnp;
    private String userId;
    private String userName;
    private Long trackId;
    private String trackName;

    public JudgeLog toEntity(Member member, Track track){
        return JudgeLog.builder()
                .member(member)
                .track(track)
                .percent(percent)
                .pnp(pnp)
                .build();
    }

    public JudgeLogResponseDto(JudgeLog judgeLog){
        this.percent = judgeLog.getPercent();
        this.pnp = judgeLog.getPnp();
        this.userId = judgeLog.getMember().getUserId();
        this.userName = judgeLog.getMember().getName();
        this.trackId = judgeLog.getTrack().getId();
        this.trackName = judgeLog.getTrack().getTitle();
    }

    @Builder
    public JudgeLogResponseDto(Double percent, TrackJudge.PNP pnp, String userId,
                               String userName, Long trackId, String trackName) {
        this.percent = percent;
        this.pnp = pnp;
        this.userId=userId;
        this.userName=userName;
        this.trackId = trackId;
        this.trackName = trackName;
    }
}
