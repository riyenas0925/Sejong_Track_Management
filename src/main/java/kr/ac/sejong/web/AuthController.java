package kr.ac.sejong.web;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log
@Controller
public class AuthController {
    // 회원가입 페이지
    @GetMapping("/joinView")
    public String joinView() {
        return "member/joinView";
    }

    // 내 정보 페이지
    @GetMapping("/modifyView")
    public String modifyView() {
        return "member/modifyView";
    }

    // 로그인 페이지
    @GetMapping("/loginView")
    public String loginView() {
        return "member/loginView";
    }

    // 중복 로그인 : 선 로그인의 접근
    @GetMapping("/memberExpired")
    public String memberExpired() {
        return "member/memberExpired";
    }

    // 권한상 접근 거부 페이지
    @GetMapping("/memberDenied")
    public String memberDenied() {
        return "member/memberDenied";
    }
}
