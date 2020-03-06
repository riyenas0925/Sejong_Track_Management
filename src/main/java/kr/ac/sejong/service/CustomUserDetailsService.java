package kr.ac.sejong.service;

import kr.ac.sejong.domain.CustomUserDetails;
import kr.ac.sejong.domain.member.Member;
import kr.ac.sejong.domain.member.MemberRepository;
import kr.ac.sejong.web.dto.MemberPwModifyDto;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Log
public class CustomUserDetailsService implements UserDetailsService {

    @Inject
    private MemberRepository repo;
    @Inject
    private PasswordEncoder passwordEncoder;

    @Transactional
    public String joinMember(Member m) {
        Member member = Member.builder()
                .id(m.getId())
                .password(passwordEncoder.encode(m.getPassword())) /*비밀번호 암호화*/
                .name(m.getName())
                .email(m.getEmail())
                .build();

        return repo.save(member).getId();
    }

    @Transactional
    public void modifyMember(String targetId, String targetPw, Member result) throws BadCredentialsException {
        Member target = repo.findById(targetId).orElseThrow(()->new IllegalArgumentException("아이디가 존재하지 않습니다."));

        if (!passwordEncoder.matches(targetPw, target.getPassword())) { //raw, bcrypt
            throw new BadCredentialsException("기존 비밀번호가 일치하지 않습니다.");
        } else {
            target.update(result.getEmail(), result.getName());
        }

        repo.save(target);
    }

    @Transactional
    public String modifyPw(MemberPwModifyDto dto) {
        Member target = repo.findById(dto.getId()).orElseThrow(()->new IllegalArgumentException("아이디가 존재하지 않습니다."));

        if (!passwordEncoder.matches(dto.getPassword(), target.getPassword())) { //raw, bcrypt
            throw new BadCredentialsException("기존 비밀번호가 일치하지 않습니다.");
        } else {
            target.updatePw(passwordEncoder.encode(dto.getNewPw()));
        }

        return dto.getId();
    }

    public UserDetails loadUserByUserId(String id) throws UsernameNotFoundException {
        /*id 일치하는 멤버 조회*/
        /*만약 id가 없으면 에러 던지고 아니면 member에 담는다.*/
        Member member = repo.findById(id).orElseThrow(() -> new UsernameNotFoundException(id));

        List<GrantedAuthority> authorities = new ArrayList<>(); /*권한*/

        return new CustomUserDetails(member.getId(), member.getPassword(), member.getName(),
                member.getEmail(), authorities);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}