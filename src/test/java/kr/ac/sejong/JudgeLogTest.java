package kr.ac.sejong;

import kr.ac.sejong.domain.trackJudge.JudgeLog.JudgeLog;
import kr.ac.sejong.domain.trackJudge.TrackJudge;
import kr.ac.sejong.service.JudgeLogService;
import kr.ac.sejong.web.dto.trackjudge.JudgeLogDto;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.List;

@RunWith(SpringRunner.class)
@ActiveProfiles(value = {"develop-h2"})
@SpringBootTest
@Log
public class JudgeLogTest {
    @Inject
    private JudgeLogService service;

    @Test
    public void 로그_기록_추가(){
        JudgeLogDto dto = JudgeLogDto.builder()
                .percent(70.0)
                .pnp(TrackJudge.PNP.NON_PASS)
                .userId("pro")
                .trackId(1L)
                .build();
        JudgeLogDto dto2 = JudgeLogDto.builder()
                .percent(40.0)
                .pnp(TrackJudge.PNP.NON_PASS)
                .userId("pro")
                .trackId(1L)
                .build();

        service.updateOrInsert(dto);
        service.updateOrInsert(dto2);
    }

    @Test
    public void 모든_로그_조회() {
        List<JudgeLog> judgeLogs = null;
        try {
            judgeLogs = service.findAllByDesc();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (JudgeLog judgeLog : judgeLogs) {
            log.info("id: " + judgeLog.getId() + " member: " + judgeLog.getMember().getName()
                    + " track: " + judgeLog.getTrack().getTitle());
        }
    }

    @Test
    public void 멤버에_의한_조회() {
        List<JudgeLog> judgeLogs = null;
        try {
            judgeLogs = service.findByMember("student");
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (JudgeLog judgeLog : judgeLogs) {
            log.info("id: " + judgeLog.getId() + " member: " + judgeLog.getMember().getName()
                    + " track: " + judgeLog.getTrack().getTitle());
        }
    }

    @Test
    public void 트랙에_의한_조회() {
        List<JudgeLog> judgeLogs = null;
        try {
            judgeLogs = service.findByTrack(1L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (JudgeLog judgeLog : judgeLogs) {
        log.info("id: " + judgeLog.getId() + " member: " + judgeLog.getMember().getName()
        + " track: " + judgeLog.getTrack().getTitle());
        }
        }

        }
