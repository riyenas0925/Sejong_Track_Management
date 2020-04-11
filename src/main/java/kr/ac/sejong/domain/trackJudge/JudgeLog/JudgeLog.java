package kr.ac.sejong.domain.trackJudge.JudgeLog;

import kr.ac.sejong.domain.member.Member;
import kr.ac.sejong.domain.track.Track;
import kr.ac.sejong.domain.trackJudge.TrackJudge;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Table(name = "judge_log")
@NoArgsConstructor
@Entity
public class JudgeLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double percent;
    private TrackJudge.PNP pnp;

    @ManyToOne
    @JoinColumn(name="memberId")
    private Member member;

    @ManyToOne
    @JoinColumn(name="trackId")
    private Track track;

    public void updateAll(Member member, Track track, Double percent, TrackJudge.PNP pnp){
        this.member = member;
        this.track = track;
        this.percent = percent;
        this.pnp = pnp;
    }

    public void updateTrack(Track track){
        this.track = track;
    }

    public void updateMember(Member member){
        this.member = member;
    }

    @Builder
    public JudgeLog(Member member, Track track, Double percent, TrackJudge.PNP pnp){
        this.member = member;
        this.track = track;
        this.percent = percent;
        this.pnp = pnp;
    }

}
