package kr.ac.sejong.web;

import kr.ac.sejong.config.auth.CustomUserDetailsService;
import kr.ac.sejong.domain.member.Member;
import kr.ac.sejong.web.dto.member.MemberModifyInfoDto;
import kr.ac.sejong.web.dto.member.MemberModifyPwDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log
@RequestMapping("/api/v1/member/*")
@RestController
@RequiredArgsConstructor
public class ApiMemberController {

    private final CustomUserDetailsService service;
    private final PasswordEncoder pe;

    // 회원가입 처리
    @PostMapping("/join")
    public ResponseEntity<String> join(@RequestBody Member member) {
        service.join(member);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //회원유무 확인
    @PostMapping("/isExist")
    public String isExist(String userId) {  //RequestBody붙여주면 안됨ㅇㅇ
        String res;
        log.info("member userid : " + userId);

        try {
            service.loadUserByUserId(userId);
            log.warning("There is already match member");
            res = "Yes";
        } catch (UsernameNotFoundException e) {
            log.info("There is no match member");
            res = "No";
        } catch (InternalAuthenticationServiceException e) {
            log.info("There is no match member...." + e.getMessage());
            res = "No";
        }
        return res;
    }

    // 정보 수정 처리
    @PostMapping("/modifyInfo")
    public ResponseEntity<String> modifyInfo(@RequestBody MemberModifyInfoDto target) {
        log.info("modifyInfo 컨트롤러 진입...." + "userId는" + target.getUserId() + "/" + target.getName() + "/" + target.getEmail() + "/" + target.getPassword()
                + "/" + target.getMajor() + "/" + target.getUniv());
        String targetId = target.getUserId();
        String targetPw = target.getPassword();
        ResponseEntity<String> entity = null;
        try {
            service.modifyInfo(targetId, targetPw, target);
            entity = new ResponseEntity<>(HttpStatus.OK);
        } catch (BadCredentialsException e) {
            log.warning("cannot modify member's info...." + e.getMessage());
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (UsernameNotFoundException e) {
            log.warning("정보수정 예외 발생...." + e.getMessage());
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return entity;
    }

    @PostMapping("/modifyPw")
    public ResponseEntity<String> modifyPw(@RequestBody MemberModifyPwDto dto) {

        ResponseEntity<String> entity = null;

        try {
            service.modifyPw(dto);
            entity = new ResponseEntity<>(HttpStatus.OK);

        } catch (BadCredentialsException e) {   // 비밀번호(실제 유저와 비밀번호가 맞지않음)
            log.warning("cannot modify member's Password...." + e.getMessage());
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (UsernameNotFoundException e) {   // 찾는 유저가 없음(동시에 타 브라우저에서 탈퇴햇을 경우)
            log.warning("cannot modify member's Password...." + e.getMessage());
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        log.info("새비밀번호가 잘 들어갔는가?:" + pe.matches(dto.getNewPw(), service.loadUserByUserId(dto.getUserId()).getPassword()));

        return entity;
    }
}