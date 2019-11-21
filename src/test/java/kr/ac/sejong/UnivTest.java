package kr.ac.sejong;

import kr.ac.sejong.domain.Univ;
import kr.ac.sejong.persistence.UnivRepository;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class UnivTest {

    @Inject
    private UnivRepository univRepository;

    @Test
    public void createUniv() {
        Univ univ = Univ.builder()
                .univTitle("Test Title")
                .univNo(1000L)
                .build();

        univRepository.save(univ);
    }

    @Test
    public void updateUniv() {
        Univ univ2 = Univ.builder()
                .univId(1L)
                .univTitle("Test Update Title")
                .univNo(3333L)
                .build();

        univRepository.save(univ2);
    }

    @Test
    public void deleteUniv() {
        univRepository.deleteById(1L);
    }

    @Test
    public void univList() {
        log.info(univRepository.findById(2L).toString());
    }

    @Test
    public void univAllList() {
        List<Univ> univList = new ArrayList<>();

        univRepository.findAll().forEach(i -> {
            univList.add(i);
        });

        log.info(univList.toString());
    }
}
