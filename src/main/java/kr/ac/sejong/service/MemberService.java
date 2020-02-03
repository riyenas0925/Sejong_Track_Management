package kr.ac.sejong.service;

import kr.ac.sejong.domain.member.Member;

public interface MemberService {
    int join(Member m);

    String IsMemberExist(Member m);
}
