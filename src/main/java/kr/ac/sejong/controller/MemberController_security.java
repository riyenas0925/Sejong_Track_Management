package kr.ac.sejong.controller;

import kr.ac.sejong.domain.CustomUserDetails;
import kr.ac.sejong.domain.Member;
import kr.ac.sejong.service.CustomUserDetailsService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

@Controller
@AllArgsConstructor
@Log
public class MemberController_security {

    @Inject
    private CustomUserDetailsService customUserDetailsService;

    @Inject
    PasswordEncoder passwordEncoder;

    // 회원가입 페이지
    @GetMapping("/joinView")
    public String joinView() {
        return "member/joinView";
    }

    // 회원가입 처리
    @PostMapping("/memberJoin")
    public String memberJoin(Member member) {
        log.info("Here is memberJoin() : "+"starting joinMember().....");
        customUserDetailsService.joinMember(member);
        log.info("Here is memberJoin() : "+" ending joinMember().....");

        return "redirect:/";
    }

    @ResponseBody
    @RequestMapping("/memberExist")
    public String memberExist(Member member) {
        String res;
        log.info("member id : " + member.getId());
        try {
            CustomUserDetails mem = (CustomUserDetails) customUserDetailsService.loadUserByUserId(member.getId());
            res = "Yes";
            log.info("There is already match member");

        } catch (UsernameNotFoundException e) {
            log.info("There is no match member");
            res = "No";
        }
        return res;
    }

    // 로그인 페이지
    @GetMapping("/loginView")
    public String loginView() {
        return "member/loginView";
    }

//    // 로그인 성공
//    @GetMapping("/memberLoginSuccess")
//    public String memberLoginSuccess(HttpSession session) {
//        return "redirect:/";
//    }

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
    @GetMapping("/myInfo")
    public String disMyInfo() {
        return "/myInfo";
    }

    // 어드민 페이지
    @GetMapping("/admin")
    public String disAdmin() {
        return "/admin";
    }
}