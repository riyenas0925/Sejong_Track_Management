package kr.ac.sejong.web;

import kr.ac.sejong.domain.CustomUserDetails;
import kr.ac.sejong.domain.member.Member;
import kr.ac.sejong.service.CustomUserDetailsService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@Controller
@AllArgsConstructor
@Log
public class MemberController_security {

    @Inject
    private CustomUserDetailsService customUserDetailsService;

    // 회원가입 페이지
    @GetMapping("/joinView")
    public String joinView() {
        return "member/joinView";
    }

    // 회원가입 처리
    @PostMapping("/memberJoin")
    public String memberJoin(Member member) {
        log.info("Here is memberJoin() : " + "starting joinMember().....");
        customUserDetailsService.joinMember(member);
        log.info("Here is memberJoin() : " + "ending joinMember().....");

        return "member/loginView";
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

    // 내 정보 페이지
    @GetMapping("/modifyView")
    public String modifyView() {
        return "member/modify";
    }

    // 정보 수정 처리
    @PostMapping("/modifyMemberInfo")
    public String modifyMemberInfo(Member target) {

        String targetId = target.getId();
        String targetPw = target.getPassword();

        try {
            customUserDetailsService.modifyMember(targetId, targetPw, target);

        }catch(BadCredentialsException e){
            return "member/modify";
        }
        return "redirect:/memberLogout";
    }

    @PostMapping("/modifyPw")
    public String modifyPw(@RequestParam("id") String targetId,
                         @RequestParam("password") String targetPw, @RequestParam("newPw") String resultPw){

        try {
            customUserDetailsService.modifyPw(targetId, targetPw, resultPw);

        }catch(BadCredentialsException e){
            return "member/modify";
        }

        return "redirect:/memberLogout";
    }

    // 로그인 페이지
    @GetMapping("/loginView")
    public String loginView() {
        log.info("loginView called.........");
        return "member/loginView";
    }

    // 중복 로그인 : 선 로그인의 접근
    @GetMapping("/memberExpired")
    public String memberExpired() {
        return "member/expired";
    }

    // 권한상 접근 거부 페이지
    @GetMapping("/memberDenied")
    public String memberDenied() {
        return "member/denied";
    }


    // 어드민 페이지
    @GetMapping("/admin")
    public String disAdmin() {
        return "/admin";
    }

    @GetMapping("/popupPwModify")
    public String popupPwModify() {
        return "member/pw_popup";
    }
}