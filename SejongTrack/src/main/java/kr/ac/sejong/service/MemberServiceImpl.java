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

//    @Override
//    public Optional<Member> login(Member m){ //멤버 존재? + 비밀번호 일치하는지
////        Optional<Member> opt_m = memberRepository.findById(m.getId());
////        Member mm = opt_m.get();
////        Optional<Member> res_m;
////
////        if(mm.getPassword().equals(m.getPassword())){
////            res_m = Optional.ofNullable(mm);
////        }
////        else{
////            res_m = Optional.ofNullable(null);
////        }
////
////        return res_m;
////
//
//    }

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
