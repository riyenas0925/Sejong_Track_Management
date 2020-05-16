package kr.ac.sejong;

import kr.ac.sejong.domain.trackJudge.TrackJudge;
import kr.ac.sejong.service.JudgeLogService;
import kr.ac.sejong.web.dto.trackjudge.JudgeLogRequestDto;
import kr.ac.sejong.web.dto.trackjudge.JudgeLogResponseDto;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@ActiveProfiles(value = {"develop-h2"})
@SpringBootTest
@Log
public class JudgeLogTest {
    @Inject
    private JudgeLogService service;

    @Test
    public void 로그_updateAll() throws Exception {
        //given
        JudgeLogRequestDto dto = JudgeLogRequestDto.builder()
                .percent(70.0)
                .pnp(TrackJudge.PNP.NON_PASS)
                .userId("pro")
                .trackId(1L)
                .build();
        JudgeLogRequestDto dto2 = JudgeLogRequestDto.builder()
                .percent(40.0)
                .pnp(TrackJudge.PNP.NON_PASS)
                .userId("pro")
                .trackId(1L)
                .build();
        List<JudgeLogRequestDto> dtos =new ArrayList<JudgeLogRequestDto>();
        dtos.add(dto);
        dtos.add(dto2);
        //when
        service.updateOrInsert(dtos);
        printAll();
    }

    @Test
    public void 모든_로그_조회() throws Exception {
        try {
            service.findAllByDesc();
        } catch (Exception e) {
            e.printStackTrace();
        }
        printAll();
    }

    @Test
    public void 멤버에_의한_조회() throws Exception {
        try {
            service.findByMember("student");
        } catch (Exception e) {
            e.printStackTrace();
        }
        printAll();
    }

    @Test
    public void 트랙에_의한_조회() throws Exception {
        try {
            service.findByTrack(1L);
        } catch (Exception e) {
            e.printStackTrace();
        }
        printAll();
    }

    @Test
    public void deleteByMember() throws Exception {
        String userId = "student";
        service.deleteByMember(userId);
        printAll();
    }

    @Test
    public void deleteByTrack() throws Exception {
        Long trackId = 1L;
        service.deleteByTrack(trackId);

        printAll();
    }

    public void printAll() throws Exception {
        List<JudgeLogResponseDto> judgeLogDtos = service.findAllByDesc();
        for (JudgeLogResponseDto dto : judgeLogDtos) {
            log.info("member: " + dto.getUserId()
                    + ", track: " + dto.getTrackId());
        }
    }
}
