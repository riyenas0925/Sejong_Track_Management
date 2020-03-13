package kr.ac.sejong.web;

import kr.ac.sejong.web.dto.CustomUserDetails;
import kr.ac.sejong.domain.member.Member;
import kr.ac.sejong.config.auth.CustomUserDetailsService;
import kr.ac.sejong.web.dto.MemberPwModifyDto;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

@Controller
@AllArgsConstructor
@Log
public class MemberRestController {

    @Inject
    private CustomUserDetailsService service;
    @Inject
    private PasswordEncoder pe;

    // 회원가입 처리
    @PostMapping("/memberJoin")
    public String memberJoin(Member member) {   //-> rest로 바꾸자
        service.joinMember(member);

        return "member/loginView";
    }

    @ResponseBody
    @RequestMapping("/memberExist")
    public String memberExist(Member member) {
        String res;
        log.info("member id : " + member.getId());
        try {
            CustomUserDetails mem = (CustomUserDetails) service.loadUserByUserId(member.getId());
            res = "Yes";
            log.warning("There is already match member");

        } catch (UsernameNotFoundException e) {
            log.warning("There is no match member");
            res = "No";
        }
        return res;
    }

    // 정보 수정 처리
    @PostMapping("/modifyMemberInfo")
    public String modifyMemberInfo(Member target) {

        String targetId = target.getId();
        String targetPw = target.getPassword();

        try {
            service.modifyMember(targetId, targetPw, target);

        } catch (BadCredentialsException e) {
            log.warning("cannot modify member's info...." + e.getMessage());
            return "member/modify";
        }
        return "redirect:/memberLogout";
    }

    @ResponseBody
    @PostMapping("/api/v1/member/modifyPw")
    public ResponseEntity<String> modifyPw(@RequestBody MemberPwModifyDto dto) {

        ResponseEntity<String> entity = null;

        try {
            service.modifyPw(dto);
            entity = new ResponseEntity<>(HttpStatus.OK);

        } catch (BadCredentialsException e) {   // 비밀번호(실제 유저와 비밀번호가 맞지않음)
            log.warning("cannot modify member's Password...." + e.getMessage());
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (IllegalArgumentException e) {   // 찾는 유저가 없음(동시에 타 브라우저에서 탈퇴햇을 경우)
            log.warning("cannot modify member's Password...." + e.getMessage());
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        log.info("새비밀번호가 잘 들어갔는가?:" + pe.matches(dto.getNewPw(), service.loadUserByUserId(dto.getId()).getPassword()));

        return entity;
    }
}