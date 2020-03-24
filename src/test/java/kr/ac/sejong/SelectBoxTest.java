package kr.ac.sejong;

import kr.ac.sejong.service.SelectBoxService;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles(value = {"develop-h2"})
@SpringBootTest
@Log
public class SelectBoxTest {

    @Autowired
    private SelectBoxService selectBoxService;

    @Test
    public void univSelect() {
        log.info(selectBoxService.univ().toString());
    }

    @Test
    public void trackSelect() {
        log.info(selectBoxService.track(1L).toString());
    }

    @Test
    public void degreeSelect() {
        log.info(selectBoxService.degree(1L).toString());
    }

    @Test
    public void CourseSchedule() {
        log.info(selectBoxService.courseSchedule().toString());
    }
}
