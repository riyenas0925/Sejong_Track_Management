package kr.ac.sejong.config.auth;

import kr.ac.sejong.domain.member.Member;
import kr.ac.sejong.domain.member.MemberRepository;
import kr.ac.sejong.web.dto.CustomUserDetails;
import kr.ac.sejong.web.dto.member.MemberModifyInfoDto;
import kr.ac.sejong.web.dto.member.MemberModifyPwDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@RequiredArgsConstructor
@Service
@Log
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository repo;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public String join(Member m) {
        Member member = Member.builder()
                .userId(m.getUserId())
                .password(passwordEncoder.encode(m.getPassword())) /*비밀번호 암호화*/
                .name(m.getName())
                .email(m.getEmail())
                .univ(m.getUniv())
                .major(m.getMajor())
                .build();

        return repo.save(member).getUserId();
    }

    @Transactional
    public void modifyInfo(String targetId, String targetPw, MemberModifyInfoDto result) throws BadCredentialsException {
        Member target = repo.findByUserId(targetId).orElseThrow(
                () -> new UsernameNotFoundException(targetId));

        if (!passwordEncoder.matches(targetPw, target.getPassword())) { //raw, bcrypt
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        } else {
            target.updateInfo(result);
            target.updateModifiedTime();
        }
    }

    @Transactional
    public String modifyPw(MemberModifyPwDto dto) {
        Member target = repo.findByUserId(dto.getUserId()).orElseThrow(() -> new UsernameNotFoundException(dto.getUserId()));

        log.info("modifyPw 비밀번호가 일치하는가?: " + passwordEncoder.matches(dto.getPassword(), target.getPassword()));
        if (!passwordEncoder.matches(dto.getPassword(), target.getPassword())) { //raw, bcrypt
            throw new BadCredentialsException("기존 비밀번호가 일치하지 않습니다.");
        } else {
            target.updatePw(passwordEncoder.encode(dto.getNewPw()));
            target.updateModifiedTime();
        }
        return dto.getUserId();
    }

    public UserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        /*id 일치하는 멤버 조회*/
        /*만약 id가 없으면 에러 던지고 아니면 member에 담는다.*/
        Member member = repo.findByUserId(userId).orElseThrow(
                () -> new UsernameNotFoundException("id가 일치하지 않습니다."));

        return CustomUserDetails.builder()
                .userId(member.getUserId())
                .password(member.getPassword())
                .name(member.getName())
                .email(member.getEmail())
                .univ(member.getUniv())
                .major(member.getMajor())
                .authorities(new ArrayList<>())
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}