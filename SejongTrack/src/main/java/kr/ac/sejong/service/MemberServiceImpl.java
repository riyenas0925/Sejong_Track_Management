package kr.ac.sejong.service;

import kr.ac.sejong.domain.Member;
import kr.ac.sejong.persistence.MemberRepository;
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
    public int join(Member m){
        //중복검사
        Optional<Member> maybeMember = memberRepository.findById(m.getId());
        logger.info("mayMember : "+maybeMember.toString());
        logger.info("isPresent : "+maybeMember.isPresent());
        if(maybeMember.isPresent()){
            logger.info("join() : Already exist member........");
            return -1;
        }
        else {
            memberRepository.save(m);
            logger.info("join() : member saved.........");
            return 1;
        }
    }

}
