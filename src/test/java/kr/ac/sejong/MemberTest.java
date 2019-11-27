package kr.ac.sejong;

import kr.ac.sejong.domain.Member;
import kr.ac.sejong.persistence.MemberRepository;
import kr.ac.sejong.service.MemberServiceImpl;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class MemberTest {

    @Inject
    MemberRepository repo;
    @Inject
    MemberServiceImpl service;

    @Test
    public void memberJoin_findById_Hangeul(){
        Optional<Member> member = repo.findById("초가스");

    }


}
