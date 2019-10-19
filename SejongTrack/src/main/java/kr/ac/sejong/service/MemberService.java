package kr.ac.sejong.service;

import kr.ac.sejong.domain.Member;

import java.util.Optional;

public interface MemberService {
    public int join(Member m);

//    public Optional<Member> login(Member m);

    public Optional<Member> findMember(Member m);

    public String IsMemberExist(Member m);
}
