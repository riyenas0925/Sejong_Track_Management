package kr.ac.sejong.service;

import kr.ac.sejong.domain.Member;
import kr.ac.sejong.persistence.MemberRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

@Service
public class MemberServiceImpl implements MemberService {

    @Inject
    MemberRepository memberRepository;

    @Override
    public void join(Member m){
        //중복검사
        Member newMember = memberRepository.findOne(m.getId());
        memberRepository.save(m);
        return;
    }

}
