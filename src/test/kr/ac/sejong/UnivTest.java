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

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class UnivTest {

    @Inject
    private UnivRepository univRepository;

    @Test
    public void createUniv() {
        Univ univ1 = new Univ();
        univ1.setUnivTitle("Test Univ Title");

        univRepository.save(univ1);

        Univ univ2 = new Univ();
        univ2.setUnivId(1L);
        univ2.setUnivTitle("Update Univ Title");

        univRepository.save(univ2);
    }
}
