package kr.ac.sejong.service;

import com.querydsl.core.NonUniqueResultException;
import kr.ac.sejong.domain.member.Member;
import kr.ac.sejong.domain.member.MemberRepository;
import kr.ac.sejong.domain.track.Track;
import kr.ac.sejong.domain.track.TrackRepository;
import kr.ac.sejong.domain.trackJudge.JudgeLog.JudgeLog;
import kr.ac.sejong.domain.trackJudge.JudgeLog.JudgeLogRepository;
import kr.ac.sejong.web.dto.trackjudge.JudgeLogDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Log
@Service
public class JudgeLogService {
    /**
     * -------- userId쓸것이다. -------
     **/
    private final JudgeLogRepository repo;
    private final MemberRepository memberRepository;
    private final TrackRepository trackRepository;

    @Transactional //여기에 왜 꼭 tx를 적용해야 반영되는가?
    public void updateOrInsert(JudgeLogDto dto) {
        try{
            log.info("judgeLog update.....");
            updateByMember(dto);
        }catch(NonUniqueResultException e) {
            log.info("judgeLog update fail ! and being inserted.....");
            insert(dto);
        }
    }

    @Transactional
    public void insert(JudgeLogDto judgeLogDto) {
        log.info("userId: " + judgeLogDto.getUserId() + ", trackId: " + judgeLogDto.getTrackId());
        Optional<JudgeLog> judgeLog = repo.findByMemberAndTrack(judgeLogDto.getUserId(), judgeLogDto.getTrackId());

        if (judgeLog.isPresent()) {
            throw new IllegalArgumentException("이미 같은 유저, 트랙에 판정log가 존재합니다..");
        } else {
            Member member = memberRepository.findByUserId(judgeLogDto.getUserId()).get();
            Track track = trackRepository.findById(judgeLogDto.getTrackId()).get();
            JudgeLog target = judgeLogDto.toEntity(member, track);

            repo.save(target);
        }
    }

    //updateByTrack은 필요없을듯
    @Transactional
    public void updateByMember(JudgeLogDto dto) {
        log.info("UPDATE- percent: " +dto.getPercent());
        JudgeLog judgeLog = repo.findByMemberAndTrack(dto.getUserId(), dto.getTrackId())
                .orElseThrow(() -> new NonUniqueResultException("There is no JudgeLog....."));

        Member member = memberRepository.findByUserId(dto.getUserId()).get();
        Track track = trackRepository.findById(dto.getTrackId()).get();

        judgeLog.updateAll(member, track, dto.getPercent(), dto.getPnp());
        log.info("UPDATE- info: " +judgeLog.getMember().getName()+", percent="+judgeLog.getPercent()+", pnp="+judgeLog.getPnp());
    }

    @Transactional(readOnly = true)
    public List<JudgeLog> findByMember(String userId) throws Exception {
        return repo.findAllByMember(userId);
    }

    @Transactional(readOnly = true)
    public List<JudgeLog> findByTrack(Long trackId) throws Exception {
        return repo.findAllByTrack(trackId);
    }

    @Transactional(readOnly = true)
    public List<JudgeLog> findAllByDesc() throws Exception {
        return repo.findAllByDesc();  //페치 조인. 딜레이 길 수도.
    }


//    @Transactional
//    public void deleteByMember(Member member) throws Exception{
//        repo.deleteByMember(member.getUserId());
//    }
//
//    @Transactional
//    public void deleteByTrack(Track track) throws Exception{
//        repo.deleteByTrack(track.getId());
//    }
}
