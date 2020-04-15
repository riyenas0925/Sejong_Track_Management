package kr.ac.sejong.service;

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
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Log
@Service
public class JudgeLogService {
    /**
     * -------- userId쓸것이다. -------
     * -------- insert, update에 tx선언 안 함 -------
     **/
    private final JudgeLogRepository repo;
    private final MemberRepository memberRepository;
    private final TrackRepository trackRepository;

    @Transactional
    public void updateOrInsert(JudgeLogDto dto) throws Exception {
        Member member = memberRepository.findByUserId(dto.getUserId()).get();
        Track track = trackRepository.findById(dto.getTrackId()).get();
        Optional<JudgeLog> judgeLog = repo.findByMemberAndTrack(dto.getUserId(), dto.getTrackId());

        if (judgeLog.isPresent()) {
            log.info("judgeLog update.....");
            JudgeLog target = judgeLog.get();
            target.updateAll(member, track, dto.getPercent(), dto.getPnp());
        } else {
            log.info("judgeLog update fail ! and being inserted.....");
            JudgeLog target = dto.toEntity(member, track);
            repo.save(target);
        }
    }

    @Transactional(readOnly = true)
    public List<JudgeLogDto> findByMember(String userId) throws Exception {
        return repo.findAllByMember(userId).stream()
                .map(JudgeLogDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<JudgeLogDto> findByTrack(Long trackId) throws Exception {
        return repo.findAllByTrack(trackId).stream()
                .map(JudgeLogDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<JudgeLogDto> findAllByDesc() throws Exception {
        return repo.findAllByDesc().stream()
                .map(JudgeLogDto::new)
                .collect(Collectors.toList());  //페치 조인. 딜레이 길 수도.
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
