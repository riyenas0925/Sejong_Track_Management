package kr.ac.sejong;

import kr.ac.sejong.domain.Degree;
import kr.ac.sejong.persistence.DegreeRepository;
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
public class DegreeTest {

    @Inject
    private DegreeRepository degreeRepository;
    
    @Test
    public void degreeList(){
        List<Degree> degreeList = new ArrayList<>();
        
        degreeRepository.findAll().forEach(i -> {
            degreeList.add(i);
        });
        
        log.info(degreeList.toString());
    }
    
    @Test
    public void deleteDegree(){
        degreeRepository.deleteById(1L);
    }
    
    @Test
    public void createDegree() {
        Degree degree = Degree.builder()
            .degreeTitle("test1")
            .build();
            
        degreeRepository.save(degree);
    }
    
    @Test
    public void updateDegree() {
        Degree degree = Degree.builder()
            .degreeId(1L)
            .degreeTitle("test1")
            .build();
            
        degreeRepository.save(degree);
    }
}
