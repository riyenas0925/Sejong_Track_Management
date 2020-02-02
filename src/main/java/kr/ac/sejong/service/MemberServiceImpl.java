package kr.ac.sejong.service;

import kr.ac.sejong.domain.Member;
import kr.ac.sejong.persistence.MemberRepository;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Optional;

@Service
@Log
public class MemberServiceImpl implements MemberService {

    @Inject
    MemberRepository memberRepository;

    @Override
    public int join(Member m) {
        if (IsMemberExist(m) == "No") { //중복검사
            memberRepository.save(m);
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String IsMemberExist(Member m) {
        Optional<Member> maybeMember = memberRepository.findById(m.getId());
        return (maybeMember.isPresent()) ? "Yes" : "No";
    }

}
