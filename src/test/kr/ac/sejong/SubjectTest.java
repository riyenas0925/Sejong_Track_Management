package kr.ac.sejong;

import kr.ac.sejong.domain.Subject;
import kr.ac.sejong.persistence.SubjectRepository;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class SubjectTest {

    @Inject
    private SubjectRepository subjectRepository;

    @Test
    public void createSubject() {
        Subject subject = Subject.builder()
                .subjectTitle("test 1234")
                .subjectNo(1234L)
                .subjectCredit(10L)
                .build();

        subjectRepository.save(subject);
    }

    @Test
    public void updateSubject() {
        Subject subject = Subject.builder()
                .subjectId(1L)
                .subjectTitle("test 1234")
                .subjectNo(1234L)
                .subjectCredit(10L)
                .build();

        subjectRepository.save(subject);
    }

    @Test
    public void deleteSubject() {
        subjectRepository.deleteById(1L);
    }

    @Test
    @Transactional
    public void listAllSubject() {
        subjectRepository.findAll().forEach(subject -> {
            log.info(subject.toString());
        });
    }
}
