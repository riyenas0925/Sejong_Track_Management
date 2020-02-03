package kr.ac.sejong.service;

import kr.ac.sejong.domain.Member.Member;
import kr.ac.sejong.domain.Member.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    private static Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);

    @Inject
    MemberRepository memberRepository;

    @Override
    public int join(Member m){ // id 중복확인만 하고 join판단
        //중복검사
        if(IsMemberExist(m) == "No"){
            memberRepository.save(m);
            return 1;
        }
        else{
            return -1;
        }
    }

    @Override
    public Optional<Member> findMember(Member m){

        return memberRepository.findById(m.getId());
    }

    @Override
    public String IsMemberExist(Member m) {
        Optional<Member> maybeMember = memberRepository.findById(m.getId());
        logger.info("maybeMember.isPresent() : "+ maybeMember.isPresent());
        return (maybeMember.isPresent()) ? "Yes" : "No";
    }

}
