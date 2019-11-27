package kr.ac.sejong.controller;

import kr.ac.sejong.domain.Member;
import kr.ac.sejong.service.MemberServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.inject.Inject;

@Controller
@AllArgsConstructor
public class MemberController_security {

    @Inject
    private MemberServiceImpl memberService;

    // 회원가입 페이지
    @GetMapping("/joinView")
    public String joinView() {
        return "member/joinView";
    }

    // 회원가입 처리
    @PostMapping("/memberJoin")
    public String memberJoin(Member member) {
        memberService.join(member);

        return "member/joinResult";
    }

    // 로그인 페이지
    @GetMapping("/loginView")
    public String loginView() {
        return "member/loginView";
    }

    // 로그인 결과 페이지
    @GetMapping("/memberLogin")
    public String memberLogin() {
        return "/";
    }

    // 로그아웃 결과 페이지
    @GetMapping("/memberLogout")
    public String memberLogout() {
        return "/";
    }

    // 접근 거부 페이지
    @GetMapping("/user/denied")
    public String dispDenied() {
        return "/denied";
    }

    // 내 정보 페이지
    @GetMapping("/user/info")
    public String dispMyInfo() {
        return "/myinfo";
    }

    // 어드민 페이지
    @GetMapping("/admin")
    public String dispAdmin() {
        return "/admin";
    }
}