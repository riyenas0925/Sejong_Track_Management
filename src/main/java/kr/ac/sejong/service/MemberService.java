package kr.ac.sejong.service;

import kr.ac.sejong.domain.Member;

import java.util.Optional;

public interface MemberService {
    int join(Member m);

    String IsMemberExist(Member m);
}
